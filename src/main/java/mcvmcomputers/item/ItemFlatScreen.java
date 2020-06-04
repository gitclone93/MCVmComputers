package mcvmcomputers.item;

import mcvmcomputers.MCVmComputersMod;
import mcvmcomputers.entities.EntityFlatScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemFlatScreen extends Item{
	public ItemFlatScreen(Settings settings) {
		super(settings);
	}
	
	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		if(!world.isClient) {
			user.getStackInHand(hand).decrement(1);
			EntityFlatScreen ek = new EntityFlatScreen(world, 
									MCVmComputersMod.thePreviewEntity.getX(),
									MCVmComputersMod.thePreviewEntity.getY(),
									MCVmComputersMod.thePreviewEntity.getZ(),
									new Vec3d(user.getPosVector().x,
												MCVmComputersMod.thePreviewEntity.getY(),
												user.getPosVector().z));
			world.spawnEntity(ek);
		}
		
		return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, user.getStackInHand(hand));
	}
}
