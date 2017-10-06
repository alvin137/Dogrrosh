package alvin137.dogrrosh;

import com.tictim.ttmpcore.api.common.TCreativeTab;
import com.tictim.ttmpcore.common.SimpleModContainer;

import alvin137.dogrrosh.item.DogItems;
import alvin137.dogrrosh.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(name = Dogrrosh.NAME, modid = Dogrrosh.MODID, version = Dogrrosh.VERSION, updateJSON = "https://raw.githubusercontent.com/alvin137/Dogrrosh/master/modupdate.json")
public class Dogrrosh {
	public static final String MODID = "dogrrosh";
	public static final String NAME = "dogrrosh";
	public static final String VERSION = "0.0.0.1";
	
	@Instance(value = MODID)
	public static Dogrrosh instance;
	
	@SidedProxy(clientSide = "alvin137.dogrrosh.proxy.ClientProxy", serverSide = "alvin137.dogrrosh.proxy.CommonProxy")
	public static CommonProxy proxy;
	public static final TCreativeTab DOGTAB = new TCreativeTab("tabDogrrosh");
	@EventHandler 
	public void preinit(FMLPreInitializationEvent e) {
		proxy.registerItems();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		
	}
	
	@EventHandler
	public void postinit(FMLPostInitializationEvent e) {
		proxy.adjustItems();
	}
	}
