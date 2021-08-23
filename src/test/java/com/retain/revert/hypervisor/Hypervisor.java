package com.retain.revert.hypervisor;

public interface Hypervisor {
	
	public boolean revertSnapAndPowerOn(String HostIP, String Username, String Password, String VMName,
			String SnapShotname) ;
	public String get_id_of_VM(String HostIP, String Username, String Password, String VMName);
	public String get_id_of_SnapShot(String HostIP, String Username, String Password, String vm_id,
			String SnapShotname);
	public boolean powerOn(String HostIP, String Username, String Password, String VM_ID);
	public void printStringException(Exception e);
}