package net.swofty.types.generic.redis;

import net.minestom.server.event.Event;
import net.swofty.commons.proxy.FromProxyChannels;
import net.swofty.proxyapi.redis.ProxyToClient;
import net.swofty.types.generic.SkyBlockGenericLoader;
import net.swofty.types.generic.event.SkyBlockEventHandler;
import net.swofty.types.generic.user.SkyBlockPlayer;
import org.json.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public class RedisRunEvent implements ProxyToClient {
    @Override
    public FromProxyChannels getChannel() {
        return FromProxyChannels.RUN_EVENT_ON_SERVER;
    }

    @Override
    public JSONObject onMessage(JSONObject message) {
        UUID uuid = UUID.fromString(message.getString("uuid"));
        String eventClassName = message.getString("event");
        String eventArgs = message.getString("data");

        SkyBlockPlayer player = SkyBlockGenericLoader.getFromUUID(uuid);
        if (player == null) return new JSONObject();

        // Access static method
        // public static CollectionUpdateEvent fromProxyUnderstandable(SkyBlockPlayer player, String string) {
        // with the arguments player and eventArgsWithoutPlayerName

        Class<?> eventClass = null;
        try {
            eventClass = Class.forName(eventClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Event event = null;
        try {
            event = (Event) eventClass.getMethod("fromProxyUnderstandable", SkyBlockPlayer.class, String.class)
                    .invoke(null, player, eventArgs);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        SkyBlockEventHandler.callSkyBlockEvent(event);

        return new JSONObject();
    }
}
