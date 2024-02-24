import java.util.Date;

public class Table {
  private TableBoard tableBoard;
  private TableLeg tableLeg;
  private int tableLegCount;
  private String screwMaterial;
  private int screwCount;
  private String wheelType;
  private int wheelCount;
  private Date madeDate;

  private static class TableBoard {
    private String material;
    private int width;
    private int length;
    private int height;
    private String color;

    public TableBoard() {
      this.material = "wood";
      this.width = 20;
      this.length = 20;
      this.height = 2;
      this.color = "wood";
    }

    public int getWidth() {
      return this.width;
    }

    public int getLength() {
      return this.length;
    }

    public int getHeight() {
      return this.height;
    }
  }

  private static class TableLeg {
    private String material;
    private int length;

    public TableLeg() {
      this.material = "wood";
      this.length = 30;
    }

    public TableLeg(String material, int length) {
      this.material = material;
      this.length = length;
    }

    public int getHeight() {
      return this.length;
    }
  }

  public int getTableSize() {
    return this.tableBoard.getLength() * this.tableBoard.getWidth();
  }

  public int getHeight() {
    return this.tableBoard.getHeight() + this.tableLeg.getHeight();
  }

  public void changeTableLeg(String material, int length ) {
    this.tableLeg = new TableLeg(material, length);
  }
}


