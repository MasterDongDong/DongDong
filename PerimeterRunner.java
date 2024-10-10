import edu.duke.*;

public class PerimeterRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }
    public int getNumPoints(Shape s) {
        int totalPoints = 0;
        for (Point currPt : s.getPoints()) {
            totalPoints += 1;
        }
        return totalPoints;
    }
    public double getAverageLength(Shape s) {
        double totalPerim = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double AverageLength = totalPerim / numPoints;
        return AverageLength;
    }
    public double getlargestSide(Shape s) {
        double max_pt = 0.0;
        Point prevPt = s.getLastPoint();
        
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            
            if (currDist > max_pt) {
                max_pt = currDist;
            } else {
                continue;
            }
        }
        return max_pt;
    }
    public double getLargestX(Shape s) {
        double max_x = 0.0;
        
        for (Point currPt : s.getPoints()) {
            double x_pt = currPt.getX(); 
            
            if (x_pt > max_x) {
                max_x = x_pt;
            } else {
                continue;
            }
        }
        return max_x;
    }
    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        
        int numPoints = getNumPoints(s);
        System.out.println(numPoints);
        double AverageLength =  getAverageLength(s);
        System.out.println(AverageLength);
        double max_pt = getlargestSide(s);
        System.out.println(max_pt);
        double max_x = getLargestX(s);
        System.out.println(max_x);
    }
    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}
