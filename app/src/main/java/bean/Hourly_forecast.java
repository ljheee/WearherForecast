package bean;

import java.io.Serializable;

public class Hourly_forecast implements Serializable {
    //时间
    String date;
    //湿度
    String hum;
    //江水概率
    String pop;
    //气压
    String pres;
    //当前温度
    String tmp;
    Wind wind;

    public class Wind {
        //风向
        String dir;
        //风力等级
        String sc;
        //风速
        String spd;

        public String getDir() {
            return dir;
        }

        public String getSc() {
            return sc;
        }

        public String getSpd() {
            return spd;
        }

        @Override
        public String toString() {
            return "Wind [dir=" + dir + ", sc=" + sc + ", spd=" + spd + "]";
        }

    }

    public String getDate() {
        return date;
    }

    public String getHum() {
        return hum;
    }

    public String getPop() {
        return pop;
    }

    public String getPres() {
        return pres;
    }

    public String getTmp() {
        return tmp;
    }

    public Wind getWind() {
        return wind;
    }

    @Override
    public String toString() {
        return "Hourly_forecast [date=" + date + ", hum=" + hum + ", pop=" + pop + ", pres=" + pres + ", tmp=" + tmp
                + ", wind=" + wind + "]" + "\n";
    }

}
