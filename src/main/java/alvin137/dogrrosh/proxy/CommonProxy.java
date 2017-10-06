package alvin137.dogrrosh.proxy;

import com.tictim.ttmpcore.common.TRegistry;
import com.tictim.ttmpcore.item.ItemModeled;

import alvin137.dogrrosh.DogrroshMaterial;
import alvin137.dogrrosh.item.EagleAxe;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

public class CommonProxy {
	static EagleAxe eagle = new EagleAxe(DogrroshMaterial.eagleToolMaterial);
	static Item dog = new ItemModeled().setRegistryName("dog");
	public void registerItems() {
		TRegistry.register(eagle);
		TRegistry.register(dog);
		
	}
	public void adjustItems() {}
}
