package bean;

public class Suggestion {
    Comf comf;
    Cw cw;
    Drsg drsg;
    Flu flu;
    Sport sport;
    Uv uv;
    Trav trav;

    //舒适度
    public class Comf {
        String brf;
        String txt;

        public String getBrf() {
            return brf;
        }

        public String getTxt() {
            return txt;
        }
    }
    //洗车指数
    public class Cw {
        String brf;
        String txt;
        public String getBrf() {
            return brf;
        }

        public String getTxt() {
            return txt;
        }
    }
    //穿衣指数
    public class Drsg {
        String brf;
        String txt;
        public String getBrf() {
            return brf;
        }

        public String getTxt() {
            return txt;
        }
    }
    //感冒指数
    public class Flu {
        String brf;
        String txt;
        public String getBrf() {
            return brf;
        }

        public String getTxt() {
            return txt;
        }

        @Override
        public String toString() {
            return "Flu{" +
                    "brf='" + brf + '\'' +
                    ", txt='" + txt + '\'' +
                    '}';
        }
    }
    //运动指数
    public class Sport {
        String brf;
        String txt;
        public String getBrf() {
            return brf;
        }

        public String getTxt() {
            return txt;
        }
    }
    //旅游指数
    public class Trav {
        String brf;
        String txt;
        public String getBrf() {
            return brf;
        }

        public String getTxt() {
            return txt;
        }
    }
    //紫外线
    public class Uv {
        String brf;
        public String getBrf() {
            return brf;
        }

    }

    public Comf getComf() {
        return comf;
    }

    public Cw getCw() {
        return cw;
    }

    public Drsg getDrsg() {
        return drsg;
    }

    public Flu getFlu() {
        return flu;
    }

    public Sport getSport() {
        return sport;
    }

    public Trav getTrav() {
        return trav;
    }

    public Uv getUv() {
        return uv;
    }

    @Override
    public String toString() {
        return "Suggestion{" +
                "comf=" + comf +
                ", cw=" + cw +
                ", drsg=" + drsg +
                ", flu=" + flu +
                ", sport=" + sport +
                ", uv=" + uv +
                ", trav=" + trav +
                '}';
    }
}
