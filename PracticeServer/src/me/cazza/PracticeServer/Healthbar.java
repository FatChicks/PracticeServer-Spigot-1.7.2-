package me.cazza.PracticeServer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Listener;

public class Healthbar
  implements Listener
{
  public static List<LivingEntity> named = new ArrayList();
  public static HashMap<LivingEntity, String> name = new HashMap();
}
