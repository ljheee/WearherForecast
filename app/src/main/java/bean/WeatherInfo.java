package bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WeatherInfo implements Serializable {
	@SerializedName("HeWeather data service 3.0")
	List<AllInfo> allInfos;

	public class AllInfo {
		BasicInfo basic;
		AirQuality aqi;
		List<Daily_forecast> daily_forecast;
		List<Hourly_forecast> hourly_forecast;
		Now now;
		Suggestion suggestion;

		public BasicInfo getBasic() {
			return basic;
		}

		public AirQuality getAqi() {
			return aqi;
		}

		public List<Daily_forecast> getDaily_forecasts() {
			return daily_forecast;
		}

		public List<Hourly_forecast> getHourly_forecasts() {
			return hourly_forecast;
		}

		public Now getNow() {
			return now;
		}

		public Suggestion getSuggestion(){return suggestion;}

		@Override
		public String toString() {
			return "AllInfo [basic=" + basic + ", aqi=" + aqi + ", daily_forecasts=" + daily_forecast
					+ ", hourly_forecasts=" + hourly_forecast + ", now=" + now + "]";
		}

	}

	public List<AllInfo> getAllInfos() {
		return allInfos;
	}

	@Override
	public String toString() {
		return "WeatherInfo [allInfos=" + allInfos + "]";
	}

}
