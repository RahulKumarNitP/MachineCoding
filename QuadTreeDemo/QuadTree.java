package QuadTreeDemo;

import java.util.ArrayList;
import java.util.List;

public class QuadTree {
    private static final int MAX_POINTS = 3;
    private Region area;
    private List<Point> points = new ArrayList<>();
    private List<QuadTree> quadTrees = new ArrayList<>();

    public QuadTree(Region area) {
        this.area = area;
    }

    private boolean addPointToOneQuadrant(Point point) {
        boolean isPointAdded;
        for (int i = 0; i < 4; i++) {
            isPointAdded = this.quadTrees.get(i)
                    .addPoint(point);
            if (isPointAdded)
                return true;
        }
        return false;
    }

    private void createQuadrants() {
        Region region;
        for (int i = 0; i < 4; i++) {
            region = this.area.getQuadrant(i);
            quadTrees.add(new QuadTree(region));
        }
    }

    public boolean addPoint(Point point) {
        if (this.area.containsPoint(point)) {
            if (this.points.size() < MAX_POINTS) {
                this.points.add(point);
                return true;
            } else {
                if (this.quadTrees.size() == 0) {
                    createQuadrants();
                }
                return addPointToOneQuadrant(point);
            }
        }
        return false;
    }

    public List<Point> search(Region searchRegion, List<Point> matches) {
        if (matches == null) {
            matches = new ArrayList<Point>();
        }
        if (!this.area.doesOverlap(searchRegion)) {
            return matches;
        } else {
            for (Point point : points) {
                if (searchRegion.containsPoint(point)) {
                    matches.add(point);
                }
            }
            if (this.quadTrees.size() > 0) {
                for (int i = 0; i < 4; i++) {
                    quadTrees.get(i)
                            .search(searchRegion, matches);
                }
            }
        }
        return matches;
    }
}