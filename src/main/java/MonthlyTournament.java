import chariot.Client;
import chariot.ClientAuth;

import java.time.LocalTime;
import java.time.ZonedDateTime;

public class MonthlyTournament{

    private String tournamentStatus;
    private String token;
    private String name;
    private String description;


    public MonthlyTournament(String token, String name, String description) {
        this.token = token;
        this.name = name;
        this.description = description;
    }


    public String getStatus(){

        ClientAuth clientAuth = Client.auth(this.token);

        try {

            for (int i = 0; i < 12; i++) {
                var months = ZonedDateTime.now().plusMonths(i).with(
                        LocalTime.parse("17:00"));
                clientAuth.tournaments().createArena(params -> params.clockBlitz3m1s().name(this.name).description(this.description).startTime(months));
            }

            return this.tournamentStatus = "tournaments created!";

        }catch (Exception e){
            e.printStackTrace();
            return this.tournamentStatus = "error";
        }

    }


}

