package bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Daily_forecast implements Serializable {
	// �ճ�����
	Astro astro;
	Cond cond;
	String date;
	Tmp tmp;

	public class Tmp {
		String max;
		String min;

		public String getMax() {
			return max;
		}

		public String getMin() {
			return min;
		}

		@Override
		public String toString() {
			return "Tmp [max=" + max + ", min=" + min + "]";
		}

	}

	public class Cond {
		@SerializedName("txt_d")
		String cond_day;
		@SerializedName("txt_n")
		String cond_night;

		public String getCond_day() {
			return cond_day;
		}

		public String getCond_night() {
			return cond_night;
		}

		@Override
		public String toString() {
			return "Cond [cond_day=" + cond_day + ", cond_night=" + cond_night + "]";
		}

	}

	public class Astro {
		@SerializedName("sr")
		String sunrise;
		@SerializedName("ss")
		String sunset;

		public String getSunrise() {
			return sunrise;
		}

		public String getSunset() {
			return sunset;
		}

		@Override
		public String toString() {
			return "Sun [sunrise=" + sunrise + ", sunset=" + sunset + "]";
		}
	}

	public Astro getAstro() {
		return astro;
	}

	public Cond getCond() {
		return cond;
	}

	public String getDate() {
		return date;
	}

	public Tmp getTmp() {
		return tmp;
	}

	@Override
	public String toString() {
		return "Daily_forecast [astro=" + astro + ", cond=" + cond + ", date=" + date + ", tmp=" + tmp + "]"+"\n";
	}

}
