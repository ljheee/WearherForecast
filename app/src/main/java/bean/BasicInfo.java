package bean;

public class BasicInfo {
		String city;
		Update update;
		
		public class Update{
			String loc;

			public String getLoc() {
				return loc;
			}

			@Override
			public String toString() {
				return "Update [loc=" + loc + "]";
			}
			
		}

		public String getCity() {
			return city;
		}

		public Update getUpdate() {
			return update;
		}

		@Override
		public String toString() {
			return "BasicInfo [city=" + city + ", update=" + update + "]";
		}
		
}
