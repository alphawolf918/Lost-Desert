package idim.managers;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class SoundManager {
	
	@ForgeSubscribe
	public void onSound(SoundLoadEvent event) {
		event.manager.addSound("awid:mob/worm/say.ogg");
		event.manager.addSound("awid:mob/worm/hurt.ogg");
		event.manager.addSound("awid:mob/worm/death.ogg");
		event.manager.addSound("awid:mob/worm/step1.ogg");
		event.manager.addSound("awid:portal/portalsound.ogg");
	}
}