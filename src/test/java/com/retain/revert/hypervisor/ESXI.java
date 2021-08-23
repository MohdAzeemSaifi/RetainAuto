package com.retain.revert.hypervisor;



import java.io.PrintWriter;
import java.io.StringWriter;
import com.retain.utility.PropertiesProvider;


import novell.util.net.ssh2.SSH2;

public class ESXI implements Hypervisor{
	
	/**
	 * Generic Function to revert Snap and Poweron InCaseofESX.Only Revert is
	 * performed here.All Other operations like Getting VM ID,Snap Shot ID from
	 * their names are performed in the subsequent functions
	 * 
	 * @param ESXIP,Username,Password,VMName,SnapShotname
	 * 
	 */
	
	public boolean revertSnapAndPowerOn(String HostIP, String Username, String Password, String VMName,
			String SnapShotname) {
		try {
			
			SSH2 esx_connection = new SSH2(HostIP, Username, Password);

			String vm_id, snap_shot_id;
			vm_id = get_id_of_VM(HostIP, Username, Password, VMName);
			snap_shot_id = get_id_of_SnapShot(HostIP, Username, Password, vm_id, SnapShotname);
			String command = "vim-cmd vmsvc/snapshot.revert  " + vm_id + "  " + snap_shot_id
					+ " true>>/dev/null;echo $?";// If set to true, the virtual
			// machine will not be
			// powered on regardless of
			// the power state when the
			// snapshot was created.
			// Default to false.
			String revert_status = esx_connection.execute(command);

			System.out.println("The Return Status of the previous command was found to be " + revert_status);
			esx_connection.disconnect();
			if (revert_status.equals("0")) {
				System.out.println("The Reverting of the Snap-shot succeeded");
				if (powerOn(HostIP, Username, Password, vm_id)) {
					System.out.println("The VM was successfully revered to the required snapshot and Poweredon");
					return true;
				} else {
					System.out.println("An Error occured while Reverting and Powered on to the required snapshot");
					return false;
				}

			} else {
				System.out.println("The Revert of the Snapshot failed due to the following reason");
				System.out.println(revert_status);
				return false;
			}
		} catch (Exception e) {
			System.out.println("An Exception was caught while reverting and powering on the VM");
			printStringException(e);
			return false;
		}

	}

	/**
	 * Gets the ID of the VM by name
	 *
	 *
	 */
	public String get_id_of_VM(String HostIP, String Username, String Password, String VMName) {
		try {
			SSH2 esx_connection = new SSH2(HostIP, Username, Password);

			System.out.println("Connecting to ESX server through SSH2... and fetching the ID of VM");

			String command = "vim-cmd vmsvc/getallvms | grep " + VMName + " | cut -d \" \" -f 1";
			String vm_id = esx_connection.execute(command);

			System.out.println("The ID of the VM is" + vm_id);
			esx_connection.disconnect();
			return vm_id;

		} catch (Exception e) {
			System.out.println("An Exception was caught while getting the ID of the VM to be reverted");
			printStringException(e);
			return null;
		}
	}

	/**
	 * Gets the Snap Shot ID ID of the VM by snap name and VM ID returned by
	 * above function
	 *
	 *
	 */
	public String get_id_of_SnapShot(String HostIP, String Username, String Password, String vm_id,
			String SnapShotname) {

		try {
			SSH2 esx_connection = new SSH2(HostIP, Username, Password);

			System.out.println("Connecting to ESX server through SSH2... and Adding Reverting the Snap-shot");

			String command = "vim-cmd vmsvc/get.snapshotinfo " + vm_id + " | grep -n " + SnapShotname
					+ " | cut -d : -f 1";
			String snapshot_id__vm_line_no_string = esx_connection.execute(command);
			System.out.println("The snap shot line number is" + snapshot_id__vm_line_no_string);
			int snapshot_id__vm_line_no_int = Integer.parseInt(snapshot_id__vm_line_no_string) + 2;
			command = "vim-cmd vmsvc/get.snapshotinfo  " + vm_id + " | sed -n " + snapshot_id__vm_line_no_int
					+ "p | cut -d = -f 2 | cut -d , -f 1 | cut -d \" \" -f 2";
			String snap_shot_id = esx_connection.execute(command);
			System.out.println("The Snap Shot ID  of the machine to be reverted is found to be " + snap_shot_id);

			esx_connection.disconnect();
			return snap_shot_id;
		} catch (Exception e) {
			System.out.println("An Exception was caught while getting the SnapShot of the VM to be reverted");
			printStringException(e);
			return null;
		}

	}

	/**
	 * Powers on of the VM after reverting the Snap shot
	 *
	 *
	 */
	public boolean powerOn(String HostIP, String Username, String Password, String VM_ID) {
		try {
			SSH2 esx_connection = new SSH2(HostIP, Username, Password);

			System.out.println("Connecting to ESX server through SSH2... and Powering on the VM");

			String command = "vim-cmd vmsvc/power.on " + VM_ID + " >>/dev/null;echo $?";
			String result = esx_connection.execute(command);
			esx_connection.disconnect();

			if (result.equals("0")) {
				System.out.println("The Powering on  of the VM succeeded");

				return true;
			} else {
				System.out.println("The Powering on the VM failed due to the followinng reason");
				System.out.println(result);
				return false;
			}
		} catch (Exception e) {
			System.out.println("An Exception was caught while Powering on the VM");
			printStringException(e);
			return false;
		}

	}
	
	
	/**
	 * Function to print the Exception Caught
	 *
	 *
	 */
	public void printStringException(Exception e) {
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		String exceptionAsString = sw.toString();
		System.out.println("The Selector Element was not found" + exceptionAsString);
	}
	
}