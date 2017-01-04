package bean;

import com.google.gson.annotations.SerializedName;
import bean.Hourly_forecast.Wind;

public class Now {

	public Cond cond;
	public String fl;
	public String hum;
	public String pcpn;
	public String pres;
	public String tmp;
	public Wind wind;

	public class Cond {
		@SerializedName("txt")
		String cond_day;

		public String getCond_day() {
			return cond_day;
		}

		@Override
		public String toString() {
			return "Cond [cond_day=" + cond_day + "]";
		}

	}

	public Cond getCond() {
		return cond;
	}

	public String getFl() {
		return fl;
	}

	public String getHum() {
		return hum;
	}

	public String getPcpn() {
		return pcpn;
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
		return "Now [cond=" + cond + ", fl=" + fl + ", hum=" + hum + ", pcpn=" + pcpn + ", pres=" + pres + ", tmp="
				+ tmp + ", wind=" + wind + "]";
	}

}
