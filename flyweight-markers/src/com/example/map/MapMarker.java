package com.example.map;

/**
 * MapMarker with Flyweight pattern applied.
 * 
 * Extrinsic state (marker-specific): lat, lng, label
 * Intrinsic state (shared): MarkerStyle reference obtained from factory
 */
public class MapMarker {

    private final double lat;
    private final double lng;
    private final String label;

    // Shared style obtained from MarkerStyleFactory
    private final MarkerStyle style;

    public MapMarker(double lat, double lng, String label, MarkerStyle style) {
        this.lat = lat;
        this.lng = lng;
        this.label = label;
        this.style = style;
    }

    public double getLat() { return lat; }
    public double getLng() { return lng; }
    public String getLabel() { return label; }
    public MarkerStyle getStyle() { return style; }
}
