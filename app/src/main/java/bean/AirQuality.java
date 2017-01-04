package bean;

import com.google.gson.annotations.SerializedName;

public class AirQuality {
	
	@SerializedName("city")
	CityAir cityAir;
	
	public class CityAir {
		String aqi;
		String pm25;
		String pm10;
		String qlty;
		String no2;
		String o3;
		String co;
		String so2;

		public String getAqi() {
			return aqi;
		}

		public String getCo() {
			return co;
		}

		public String getNo2() {
			return no2;
		}

		public String getO3() {
			return o3;
		}

		public String getPm10() {
			return pm10;
		}

		public String getPm25() {
			return pm25;
		}

		public String getQlty() {
			return qlty;
		}public String getSo2() {
			return so2;
		}
	}

	public AirQuality(CityAir cityAir) {
		this.cityAir = cityAir;
	}

	public CityAir getCityAir() {
		return cityAir;
	}

	@Override
	public String toString() {
		return "AirQuality{" +
				"cityAir=" + cityAir +
				'}';
	}
}
