package common.extensions

import org.junit.Test

class StringXKtTest {

    @Test
    fun jsonable() {
    }

    @Test
    fun toDartType() {
    }

    @Test
    fun underscore2Camel() {
    }

    @Test
    fun placeholder() {
    }

    @Test
    fun isModel() {
    }

    @Test
    fun toDartModel() {
        val source = """
  //
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolylineOptions implements Parcelable {
    public static final PolylineOptionsCreator CREATOR = new PolylineOptionsCreator();
    public static final int DOTTEDLINE_TYPE_SQUARE = 0;
    public static final int DOTTEDLINE_TYPE_CIRCLE = 1;
    private final List<LatLng> b;
    private float c = 10.0F;
    private int d = -16777216;
    private float e = 0.0F;
    private boolean f = true;
    String a;
    private BitmapDescriptor g;
    private List<BitmapDescriptor> h;
    private List<Integer> i;
    private List<Integer> j;
    private boolean k = true;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private float o = 1.0F;
    private boolean p = false;
    private int q = 0;
    private PolylineOptions.LineCapType r;
    private PolylineOptions.LineJoinType s;
    private float t;

    public PolylineOptions() {
        this.r = PolylineOptions.LineCapType.LineCapRound;
        this.s = PolylineOptions.LineJoinType.LineJoinBevel;
        this.t = -1.0F;
        this.b = new ArrayList();
    }

    public PolylineOptions setUseTexture(boolean var1) {
        this.k = var1;
        return this;
    }

    public PolylineOptions setCustomTexture(BitmapDescriptor var1) {
        this.g = var1;
        return this;
    }

    public BitmapDescriptor getCustomTexture() {
        return this.g;
    }

    public PolylineOptions setCustomTextureList(List<BitmapDescriptor> var1) {
        this.h = var1;
        return this;
    }

    public List<BitmapDescriptor> getCustomTextureList() {
        return this.h;
    }

    public PolylineOptions setCustomTextureIndex(List<Integer> var1) {
        this.j = var1;
        return this;
    }

    public List<Integer> getCustomTextureIndex() {
        return this.j;
    }

    public PolylineOptions colorValues(List<Integer> var1) {
        this.i = var1;
        return this;
    }

    public List<Integer> getColorValues() {
        return this.i;
    }

    public PolylineOptions useGradient(boolean var1) {
        this.n = var1;
        return this;
    }

    public boolean isUseGradient() {
        return this.n;
    }

    public boolean isUseTexture() {
        return this.k;
    }

    public boolean isGeodesic() {
        return this.l;
    }

    public PolylineOptions add(LatLng var1) {
        if (var1 != null) {
            try {
                this.b.add(var1);
            } catch (Throwable var3) {
                var3.printStackTrace();
            }
        }

        return this;
    }

    public PolylineOptions add(LatLng... var1) {
        if (var1 != null) {
            try {
                this.b.addAll(Arrays.asList(var1));
            } catch (Throwable var3) {
                var3.printStackTrace();
            }
        }

        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> var1) {
        if (var1 != null) {
            try {
                Iterator var2 = var1.iterator();

                while(var2.hasNext()) {
                    LatLng var3 = (LatLng)var2.next();
                    this.b.add(var3);
                }
            } catch (Throwable var4) {
                var4.printStackTrace();
            }
        }

        return this;
    }

    public PolylineOptions width(float var1) {
        this.c = var1;
        return this;
    }

    public PolylineOptions color(int var1) {
        this.d = var1;
        return this;
    }

    public PolylineOptions zIndex(float var1) {
        this.e = var1;
        return this;
    }

    public PolylineOptions visible(boolean var1) {
        this.f = var1;
        return this;
    }

    public PolylineOptions geodesic(boolean var1) {
        this.l = var1;
        return this;
    }

    public PolylineOptions setDottedLine(boolean var1) {
        this.m = var1;
        return this;
    }

    public boolean isDottedLine() {
        return this.m;
    }

    public PolylineOptions setDottedLineType(int var1) {
        this.q = var1 == 0 ? 0 : 1;
        return this;
    }

    public PolylineOptions lineCapType(PolylineOptions.LineCapType var1) {
        if (var1 != null) {
            this.r = var1;
        }

        return this;
    }

    public PolylineOptions lineJoinType(PolylineOptions.LineJoinType var1) {
        if (var1 != null) {
            this.s = var1;
        }

        return this;
    }

    public PolylineOptions.LineCapType getLineCapType() {
        return this.r;
    }

    public PolylineOptions.LineJoinType getLineJoinType() {
        return this.s;
    }

    public int getDottedLineType() {
        return this.q;
    }

    public List<LatLng> getPoints() {
        return this.b;
    }

    public float getWidth() {
        return this.c;
    }

    public int getColor() {
        return this.d;
    }

    public float getZIndex() {
        return this.e;
    }

    public boolean isVisible() {
        return this.f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        var1.writeTypedList(this.b);
        var1.writeFloat(this.c);
        var1.writeInt(this.d);
        var1.writeInt(this.q);
        var1.writeFloat(this.e);
        var1.writeFloat(this.o);
        var1.writeString(this.a);
        var1.writeInt(this.r.getTypeValue());
        var1.writeInt(this.s.getTypeValue());
        var1.writeBooleanArray(new boolean[]{this.f, this.m, this.l, this.n, this.p});
        if (this.g != null) {
            var1.writeParcelable(this.g, var2);
        }

        if (this.h != null) {
            var1.writeList(this.h);
        }

        if (this.j != null) {
            var1.writeList(this.j);
        }

        if (this.i != null) {
            var1.writeList(this.i);
        }

        var1.writeFloat(this.t);
    }

    public PolylineOptions transparency(float var1) {
        this.o = var1;
        return this;
    }

    public float getTransparency() {
        return this.o;
    }

    public PolylineOptions aboveMaskLayer(boolean var1) {
        this.p = var1;
        return this;
    }

    public boolean isAboveMaskLayer() {
        return this.p;
    }

    public void setPoints(List<LatLng> var1) {
        if (var1 != null && this.b != var1) {
            try {
                this.b.clear();
                this.b.addAll(var1);
            } catch (Throwable var3) {
                var3.printStackTrace();
            }
        }

    }

    public float getShownRatio() {
        return this.t;
    }

    public PolylineOptions setShownRatio(float var1) {
        this.t = var1;
        return this;
    }

    public static enum LineJoinType {
        LineJoinBevel(0),
        LineJoinMiter(1),
        LineJoinRound(2);

        private int a;

        private LineJoinType(int var3) {
            this.a = var3;
        }

        public int getTypeValue() {
            return this.a;
        }

        public static PolylineOptions.LineJoinType valueOf(int var0) {
            PolylineOptions.LineJoinType[] var1 = values();
            var0 = Math.max(0, Math.min(var0, var1.length));
            return var1[var0];
        }
    }

    public static enum LineCapType {
        LineCapButt(0),
        LineCapSquare(1),
        LineCapArrow(2),
        LineCapRound(3);

        private int a;

        private LineCapType(int var3) {
            this.a = var3;
        }

        public static PolylineOptions.LineCapType valueOf(int var0) {
            PolylineOptions.LineCapType[] var1 = values();
            var0 = Math.max(0, Math.min(var0, var1.length));
            return var1[var0];
        }

        public int getTypeValue() {
            return this.a;
        }
    }
}

        """.trimIndent()

        println(source.toDartModel())
    }
}