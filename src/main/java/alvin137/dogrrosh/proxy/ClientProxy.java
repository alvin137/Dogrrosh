package alvin137.dogrrosh.proxy;

import alvin137.dogrrosh.Dogrrosh;

public class ClientProxy extends CommonProxy {
	@Override
	public void adjustItems() {
		Dogrrosh.DOGTAB.setIcon(dog, 0);
	}
}	
