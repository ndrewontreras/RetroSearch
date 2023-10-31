package objects;

public class ToyotaVehicle implements Comparable<ToyotaVehicle> {
    private String modelCode;

    private int modelYear;

    private String modelName;

    private String engine;

    private boolean sedan;

    private String funFact;

    public ToyotaVehicle(int modelYear, String modelName, String modelCode, String engine, boolean sedan, String funFact) {
        this.modelCode = modelCode;
        this.modelYear = modelYear;
        this.modelName = modelName;
        this.engine = engine;
        this.sedan = sedan;
        this.funFact = funFact;
    }

    public ToyotaVehicle() {
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public boolean isSedan() {
        return sedan;
    }

    public void setSedan(boolean sedan) {
        this.sedan = sedan;
    }

    public String getFunFact() {
        return funFact;
    }

    public void setFunFact(String funFact) {
        this.funFact = funFact;
    }

    public String sedanResult() {
        String result = (sedan) ? "Y" : "N";
        return result;
    }

    @Override
    public String toString() {
        String toyotaVehicle = ("Year: " + modelYear + " \t-\t Name: " +  modelName + " \t-\t Model code: " + modelCode + " \t-\t Engine types: " + engine + " \t-\t Sedan?: " + sedanResult() + " \t-\t Fun fact: " + funFact);
        return toyotaVehicle;
    }

    @Override
    public int compareTo(ToyotaVehicle o) {
        if(this.modelYear == o.modelYear) {
            return this.modelCode.compareTo(o.modelCode);
        } else {
            return o.modelYear - this.modelYear;
        }
    }
}
