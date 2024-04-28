//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import info5100.number_recognition2.model.MainModel;
//import info5100.number_recognition2.view.DrawArea;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//public class DrawAreaTest {
//
//  private DrawArea drawArea;
//
//  @BeforeEach
//  public void setUp() {
//    drawArea = new DrawArea(new MainModel());
//  }
//
//  @Test
//  public void testClearLines() {
//    drawArea.startNewLine(0, 0);
//    drawArea.addPointToCurrentLine(100, 100);
//    drawArea.clearLines();
//    assertTrue(drawArea.getLines().isEmpty(), "Lines should be empty after clearing");
//  }
//
//  @Test
//  public void testAddPointToLine() {
//    DrawArea drawArea = new DrawArea(new MainModel());
//    drawArea.startNewLine(0, 0);
//    drawArea.addPointToCurrentLine(50, 50);
//    drawArea.addPointToCurrentLine(100, 100);
//
//    // Assuming getLines() and points are accessible or have getter methods
//    assertEquals(3, drawArea.getLines().get(0).size(), "Line should have three points");
//  }
//}
