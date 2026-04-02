package tower;

public class TowerSolver {
    private TowerModel model;

    public TowerSolver()
    {
    }

    public void solve(TowerModel model)
    {
        this.model = model;
        solve(model.getHeight(), model.getTowers()[0], model.getTowers()[1], model.getTowers()[2]);
    }

    // Create an overloaded solve(...) method
    // This new method will be recursive (call itself)
    //
    // [ solve method here]
    //

}
