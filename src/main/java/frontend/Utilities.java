package frontend;

import javax.swing.*;

public class Utilities {
    public static void warnIfOutOfBorder(double x, double y) {
        if (x > 1200 || x < 0 || y > 600 || y < 0) {
            JOptionPane.showMessageDialog(null, "Shape might be out of bounds.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void warnIfOutOfBorder(double x1, double y1, double x2, double y2) {
        if (x1 > 1200 || x1 < 0 || y1 > 600 || y1 < 0 || x2 > 1200 || x2 < 0 || y2 > 600 || y2 < 0) {
            JOptionPane.showMessageDialog(null, "Shape might be out of bounds.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
//    public static void warnIfOutOfBorder(double... coordinates) {
//      for (double coordinate : coordinates) {
//          if (coordinate > 700 || coordinate < 0) {
//              JOptionPane.showMessageDialog(null, "Shape might be out of bounds.", "Warning", JOptionPane.WARNING_MESSAGE);
//              return;
//          }
//      }
//    }
//        if (x > 1200 || x < 0 || y > 600 || y < 0) {
//            JOptionPane.showMessageDialog(null, "Shape might be out of bounds.", "Warning", JOptionPane.WARNING_MESSAGE);
//        }
//    }

}
