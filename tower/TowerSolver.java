package tower;

public class TowerSolver {
    private TowerModel model;

    public TowerSolver() {
    }

    public void solve(TowerModel model) {
        this.model = model;
        solve(model.getHeight(), model.getTowers()[0], model.getTowers()[1], model.getTowers()[2]);
    }

    private void solve(int n, IntegerStack from, IntegerStack to, IntegerStack aux) {
        if (n == 1) {
            to.push(from.pop());
        } else {
            solve(n - 1, from, aux, to);
            to.push(from.pop());
            solve(n - 1, aux, to, from);
        }
    }
}