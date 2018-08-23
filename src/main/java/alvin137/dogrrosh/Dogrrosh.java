package alvin137.dogrrosh;

import com.tictim.utilib.util.TCreativeTab;
import com.tictim.utilib.modeled.ModelLoadHelper;
import com.tictim.utilib.util.SimpleModContainer;

import alvin137.dogrrosh.item.DogItems;
import alvin137.dogrrosh.item.EagleAxe;
import alvin137.dogrrosh.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
@Mod(name = Dogrrosh.NAME, modid = Dogrrosh.MODID, version = Dogrrosh.VERSION, updateJSON = "https://raw.githubusercontent.com/alvin137/Dogrrosh/master/modupdate.json")
public class Dogrrosh {
	public static final String MODID = "dogrrosh";
	public static final String NAME = "dogrrosh";
	public static final String VERSION = "0.0.0.1";

	@Instance(value = MODID)
	public static Dogrrosh instance;

	@SidedProxy(clientSide = "alvin137.dogrrosh.proxy.ClientProxy", serverSide = "alvin137.dogrrosh.proxy.CommonProxy")
	public static CommonProxy proxy;
	public static final TCreativeTab DOGTAB = TCreativeTab.builder("tabDogrrosh").newItemForIcon(MODID, "dog").build();

	@EventHandler
	public void preinit(FMLPreInitializationEvent e) {
		MinecraftForge.EVENT_BUS.register(instance);
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		
	}

	@EventHandler
	public void postinit(FMLPostInitializationEvent e) {
		
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> e) {
		IForgeRegistry<Item> registry = e.getRegistry();
		ModelLoadHelper.registerItemAndModels(registry, new EagleAxe());
	}

}
