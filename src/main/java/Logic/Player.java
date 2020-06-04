package Logic;

public class Player {

    private boolean human = false;
    private PieceColor control;
    private String name = "AI";
    private Graph graph;
    private boolean current = false;
    private boolean resigned = false;

    public boolean isCurrent() {
        return current;
    }

    public Player(PieceColor control){
        this.control = control;
        this.graph = new Graph(control);
        if (control == PieceColor.BLACK) this.current = true;
    }

    public Player(PieceColor control, String name) {
        this.human = true;
        this.control = control;
        this.name = name;
        this.graph = new Graph(control);
        if (control == PieceColor.BLACK) this.current = true;
    }

    public boolean isHuman() {
        return human;
    }

    public String getName() {
        return name;
    }

    public PieceColor getControl() {
        return control;
    }

    public Graph getGraph(){ return graph; }

    void setGraph(Graph graph){ this.graph = graph; }

    void setControl(PieceColor control) {
        this.control = control;
    }

    public void setCurrent(boolean bool) {
        this.current = bool;
    }

    public void setResigned() {
        this.resigned = true;
    }

    public boolean isResigned() { return resigned; }
}

