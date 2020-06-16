package me.yohom.fluttify.extensions

import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Platform
import org.junit.jupiter.api.Test
import parser.java.JavaParser
import parser.java.JavaParserBaseListener

class MethodContextXKtTest {

    @Test
    fun formalParams() {
        TEST.walkTree(object : JavaParserBaseListener() {
            override fun enterMethodDeclaration(ctx: JavaParser.MethodDeclarationContext) {
                if (ctx.name().isObfuscated()) return
                Method(
                    ctx.returnType(),
                    ctx.name(),
                    ctx.formalParams(),
                    ctx.isStatic(),
                    ctx.isAbstract(),
                    ctx.isPublic(),
                    "",
                    Platform.Android,
                    ctx.isDeprecated(),
                    isGenericMethod = ctx.isGenericMethod()
                )
            }
        })
    }

    @Test
    fun testFormalParams() {
    }
}

const val TEST = """
    package com.amap.api.fence;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.loc.dp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeoFence implements Parcelable {
   public static final String BUNDLE_KEY_FENCEID = "fenceid";
   public static final String BUNDLE_KEY_CUSTOMID = "customId";
   public static final String BUNDLE_KEY_FENCESTATUS = "event";
   public static final String BUNDLE_KEY_LOCERRORCODE = "location_errorcode";
   public static final String BUNDLE_KEY_FENCE = "fence";
   public static final int ADDGEOFENCE_SUCCESS = 0;
   public static final int ERROR_CODE_INVALID_PARAMETER = 1;
   public static final int ERROR_CODE_FAILURE_CONNECTION = 4;
   public static final int ERROR_CODE_FAILURE_PARSER = 5;
   public static final int ERROR_CODE_FAILURE_AUTH = 7;
   public static final int ERROR_CODE_UNKNOWN = 8;
   public static final int ERROR_NO_VALIDFENCE = 16;
   public static final int ERROR_CODE_EXISTS = 17;
   public static final int STATUS_IN = 1;
   public static final int STATUS_OUT = 2;
   public static final int STATUS_STAYED = 3;
   public static final int STATUS_LOCFAIL = 4;
   public static final int STATUS_UNKNOWN = 0;
   public static final int TYPE_ROUND = 0;
   public static final int TYPE_POLYGON = 1;
   public static final int TYPE_AMAPPOI = 2;
   public static final int TYPE_DISTRICT = 3;
   private String a;
   private String b;
   private String c;
   private PendingIntent d = null;
   private int e = 0;
   private PoiItem f = null;
   private List<DistrictItem> g = null;
   private List<List<DPoint>> h;
   private float i = 0.0F;
   private long j = -1L;
   private int k = 1;
   private float l = 0.0F;
   private float m = 0.0F;
   private DPoint n = null;
   private int o = 0;
   private long p = -1L;
   private boolean q = true;
   private AMapLocation r = null;
   public static final Creator<GeoFence> CREATOR = new GeoFence${'$'}1();

   public GeoFence() {
   }

   public String getFenceId() {
      return this.a;
   }

   public void setFenceId(String var1) {
      this.a = var1;
   }

   public String getCustomId() {
      return this.b;
   }

   public void setCustomId(String var1) {
      this.b = var1;
   }

   public String getPendingIntentAction() {
      return this.c;
   }

   public void setPendingIntentAction(String var1) {
      this.c = var1;
   }

   public PendingIntent getPendingIntent() {
      return this.d;
   }

   public void setPendingIntent(PendingIntent var1) {
      this.d = var1;
   }

   public int getType() {
      return this.e;
   }

   public void setType(int var1) {
      this.e = var1;
   }

   public PoiItem getPoiItem() {
      return this.f;
   }

   public void setPoiItem(PoiItem var1) {
      this.f = var1;
   }

   public List<DistrictItem> getDistrictItemList() {
      return this.g;
   }

   public void setDistrictItemList(List<DistrictItem> var1) {
      this.g = var1;
   }

   public List<List<DPoint>> getPointList() {
      return this.h;
   }

   public void setPointList(List<List<DPoint>> var1) {
      this.h = var1;
   }

   public float getRadius() {
      return this.i;
   }

   public void setRadius(float var1) {
      this.i = var1;
   }

   public long getExpiration() {
      return this.j;
   }

   public void setExpiration(long var1) {
      if (var1 < 0L) {
         this.j = -1L;
      } else {
         this.j = var1 + dp.c();
      }
   }

   public int getActivatesAction() {
      return this.k;
   }

   public void setActivatesAction(int var1) {
      this.k = var1;
   }

   public int getStatus() {
      return this.o;
   }

   public void setStatus(int var1) {
      this.o = var1;
   }

   public long getEnterTime() {
      return this.p;
   }

   public void setEnterTime(long var1) {
      this.p = var1;
   }

   public DPoint getCenter() {
      return this.n;
   }

   public void setCenter(DPoint var1) {
      this.n = var1;
   }

   public float getMinDis2Center() {
      return this.l;
   }

   public void setMinDis2Center(float var1) {
      this.l = var1;
   }

   public float getMaxDis2Center() {
      return this.m;
   }

   public void setMaxDis2Center(float var1) {
      this.m = var1;
   }

   public boolean isAble() {
      return this.q;
   }

   public void setAble(boolean var1) {
      this.q = var1;
   }

   public void setCurrentLocation(AMapLocation var1) {
      this.r = var1.clone();
   }

   public AMapLocation getCurrentLocation() {
      return this.r;
   }

   public boolean equals(Object var1) {
      if (!(var1 instanceof GeoFence)) {
         return false;
      } else {
         GeoFence var2 = (GeoFence)var1;
         if (TextUtils.isEmpty(this.b)) {
            if (!TextUtils.isEmpty(var2.b)) {
               return false;
            }
         } else if (!this.b.equals(var2.b)) {
            return false;
         }

         if (this.n == null) {
            if (var2.n != null) {
               return false;
            }
         } else if (!this.n.equals(var2.n)) {
            return false;
         }

         if (this.i != var2.i) {
            return false;
         } else {
            if (this.h == null) {
               if (var2.h != null) {
                  return false;
               }
            } else if (!this.h.equals(var2.h)) {
               return false;
            }

            return true;
         }
      }
   }

   public int hashCode() {
      return this.b.hashCode() + this.h.hashCode() + this.n.hashCode() + (int)(100.0F * this.i);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.a);
      var1.writeString(this.b);
      var1.writeString(this.c);
      var1.writeParcelable(this.d, var2);
      var1.writeInt(this.e);
      var1.writeParcelable(this.f, var2);
      var1.writeTypedList(this.g);
      var1.writeFloat(this.i);
      var1.writeLong(this.j);
      var1.writeInt(this.k);
      var1.writeFloat(this.l);
      var1.writeFloat(this.m);
      var1.writeParcelable(this.n, var2);
      var1.writeInt(this.o);
      var1.writeLong(this.p);
      if (this.h != null && !this.h.isEmpty()) {
         var1.writeInt(this.h.size());
         Iterator var3 = this.h.iterator();

         while(var3.hasNext()) {
            List var4 = (List)var3.next();
            var1.writeTypedList(var4);
         }
      }

      var1.writeByte((byte)(this.q ? 1 : 0));
      var1.writeParcelable(this.r, var2);
   }

   protected GeoFence(Parcel var1) {
      this.a = var1.readString();
      this.b = var1.readString();
      this.c = var1.readString();
      this.d = (PendingIntent)var1.readParcelable(PendingIntent.class.getClassLoader());
      this.e = var1.readInt();
      this.f = (PoiItem)var1.readParcelable(PoiItem.class.getClassLoader());
      this.g = var1.createTypedArrayList(DistrictItem.CREATOR);
      this.i = var1.readFloat();
      this.j = var1.readLong();
      this.k = var1.readInt();
      this.l = var1.readFloat();
      this.m = var1.readFloat();
      this.n = (DPoint)var1.readParcelable(DPoint.class.getClassLoader());
      this.o = var1.readInt();
      this.p = var1.readLong();
      int var2;
      if ((var2 = var1.readInt()) != 0) {
         this.h = new ArrayList();

         for(int var3 = 0; var3 < var2; ++var3) {
            this.h.add(var1.createTypedArrayList(DPoint.CREATOR));
         }
      }

      this.q = var1.readByte() != 0;
      this.r = (AMapLocation)var1.readParcelable(AMapLocation.class.getClassLoader());
   }
}
"""