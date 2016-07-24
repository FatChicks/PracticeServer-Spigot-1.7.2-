 package me.cazza.PracticeServer;
 
 import org.bukkit.metadata.MetadataValue;
 import org.bukkit.plugin.Plugin;
 
 public class MyMetadata
   implements MetadataValue
 {
   Object value;
   Plugin p;
   
   public MyMetadata(Plugin p, Object o)
   {
     this.p = p;
     this.value = o;
   }
   
   public boolean equals(Object obj)
   {
     return this.value.equals(obj);
   }
   
   public void set(Object o)
   {
     this.value = o;
   }
   
   public boolean asBoolean()
   {
     throw new NullPointerException();
   }
   
   public byte asByte()
   {
     throw new NullPointerException();
   }
   
   public double asDouble()
   {
     throw new NullPointerException();
   }
   
   public float asFloat()
   {
     throw new NullPointerException();
   }
   
   public int asInt()
   {
     throw new NullPointerException();
   }
   
   public long asLong()
   {
     throw new NullPointerException();
   }
   
   public short asShort()
   {
     throw new NullPointerException();
   }
   
   public String asString()
   {
     throw new NullPointerException();
   }
   
   public Plugin getOwningPlugin()
   {
     return this.p;
   }
   
   public void invalidate() {}
   
   public Object value()
   {
     return this.value;
   }
 }