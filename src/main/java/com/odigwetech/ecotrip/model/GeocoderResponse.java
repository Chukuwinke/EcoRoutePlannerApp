package com.odigwetech.ecotrip.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeocoderResponse {
    @JsonProperty("resourceSets")
    private ResourceSet[] resourceSets;

    public ResourceSet[] getResourceSets(){
        return resourceSets;
    }

    public static class ResourceSet {
        @JsonProperty("resources")
        private Resource[] resources;

        public  Resource[] getResources(){
            return resources;
        }

        public  static class Resource{
            @JsonProperty("point")
            private Point point;

            public Point getPoint() {
                return point;
            }
            public static class Point{
                @JsonProperty("coordinates")
                private double[] coordinates;

                public double[] getCoordinates(){
                    return coordinates;
                }
            }
        }
    }
}
