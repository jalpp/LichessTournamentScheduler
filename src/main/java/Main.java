public class Main {

    public static void main(String[] args) {
        MonthlyTournament monthlyTournament = new MonthlyTournament("Your Lichess API token", "tournament name", "tournament description");
        System.out.print(monthlyTournament.getStatus());
    }


}
