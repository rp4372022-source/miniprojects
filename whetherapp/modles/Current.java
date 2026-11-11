package modles;

public class Current {
    private double temp_C;
    private double temnp_f;
    private int is_day;
    private double wind_kph;
    private int humidity;
    private double feelslike_c;
    private Condition condition;
    
    class Condition{
        private String text;
        private String icon;

        Condition(String text, String icon){
            this.text = text;
            this.icon = icon;
        }

        public String getText() {
            return text;
        }

        public String getIcon() {
            return icon;
        }

    }

    public Current(double temp_C, double temnp_f, int is_day, double wind_kph, int humidity, double feelslike_c,
            Condition condition) {
        this.temp_C = temp_C;
        this.temnp_f = temnp_f;
        this.is_day = is_day;
        this.wind_kph = wind_kph;
        this.humidity = humidity;
        this.feelslike_c = feelslike_c;
        this.condition = condition;
    }

    public double getTemp_C() {
        return temp_C;
    }

    public double getTemnp_f() {
        return temnp_f;
    }

    public int getIs_day() {
        return is_day;
    }

    public double getWind_kph() {
        return wind_kph;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getFeelslike_c() {
        return feelslike_c;
    }

    public Condition getCondition() {
        return condition;
    }

    @Override
    public String toString() {
        return "Current [temp_C=" + temp_C + ", temnp_f=" + temnp_f + ", is_day=" + is_day + ", wind_kph=" + wind_kph
                + ", humidity=" + humidity + ", feelslike_c=" + feelslike_c + ", condition=" + condition
                + ", getTemp_C()=" + getTemp_C() + ", getTemnp_f()=" + getTemnp_f() + ", getIs_day()=" + getIs_day()
                + ", getWind_kph()=" + getWind_kph() + ", getHumidity()=" + getHumidity() + ", getFeelslike_c()="
                + getFeelslike_c() + ", getCondition()=" + getCondition() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    
}
