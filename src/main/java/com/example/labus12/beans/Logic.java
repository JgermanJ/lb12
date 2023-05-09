package com.example.labus12.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

    @Component
    @Getter
    @SessionScope
    @NoArgsConstructor
    public class Logic {
        private List<Point> points=new ArrayList<>();
        double eps = 1.0E-4;


        public void operation(double begin, double end, double step) {
            for (double i = begin; i < end; i+=step) {
                double y = f(i);
                points.add(new Point(i, y));
            }
        }

        public double f(double x) {
            if (x > 3.4 - this.eps) {
                return Math.sin(x) * Math.log(x);
            } else if (x <= 3.4 - this.eps) {
                return Math.pow(Math.cos(x), 2);
            }
            return 0;
        }


        public double findMaxY() {
            double maxY = Double.NEGATIVE_INFINITY;
            for (Point p : points) {
                if (p.getY() > maxY) {
                    maxY = p.getY();
                }
            }
            return maxY;
        }

        public int findMaxYIndex() {
            double maxY = Double.NEGATIVE_INFINITY;
            int maxIndex = -1;
            for (int i = 0; i < points.size(); i++) {
                Point p = points.get(i);
                if (p.getY() > maxY) {
                    maxY = p.getY();
                    maxIndex = i;
                }
            }
            return maxIndex;
        }

        public double findMaxX() {
            for (Point p : points) {
                if (p.getY() == findMaxY()) {
                    return p.getX();
                }
            }
            return Double.NaN;
        }

        public double findMinY() {
            double minY = 0;
            for (Point p : points) {
                if (p.getY() < minY) {
                    minY = p.getY();
                }
            }
            return minY;
        }

        public int findMinYIndex() {
            double minY = 0;
            int minIndex = -1;
            for (int i = 0; i < points.size(); i++) {
                Point p = points.get(i);
                if (p.getY() < minY) {
                    minY = p.getY();
                    minIndex = i;
                }
            }
            return minIndex;
        }

        public double findMinX() {
            for (Point p : points) {
                if (p.getY() == findMinY()) {
                    return p.getX();
                }
            }
            return Double.NaN;
        }

        public double sum() {
            double Sum = 0.0;
            for (Point p : points) {
                Sum += p.getY();
            }
            return Sum;
        }

        public double average() {
            double avar = sum();
            avar /= points.size();
            return avar;
        }
    }
