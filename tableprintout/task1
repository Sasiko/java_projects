/* 
Psuedocode
Initialization of constants such as BatteryPower
Initialization of current and voltage
Initialization of variables in which the result will be stored (chargingEfficiency and chardingTime)
if voltage == 230
        apply single phase power formula to calculate power
else if voltage == 400
        apply three phase power formula to calculate power

calculate charging time from power(charging efficiency) from battery power
print the variables
*/

public class Task1 {
    // this function takes voltage and current as input and calculates the power for single phase
    public double singlePhasePower(double voltage, double current)
    {
        double power = voltage*current;
        power = power/1000;
        return Math.floor(power * 100) / 100;
    }
    // this function rounds the numbers to two decimal places
    public double ConvertToTwoDecimalPlaces(double num)
    {
        return Math.floor(num * 100) / 100;
    }
    // this function takes voltage and current as input and calculates the power for triple phase
    public double ThreePhasePower(double voltage, double current)
    {
        double power = voltage*current* Math.sqrt(3);;
        power = power/1000;
        return Math.floor(power * 100) / 100;
    }
    // this function takes voltage , current , charging efficiency and charging time as input and prints it
    void priting(double voltage, double current, double chargingEfficiency, double chardingTime)
    {
        System.out.print(voltage + "\t\t\t"+ current + "\t\t\t"+ chargingEfficiency + "\t\t\t"+ chardingTime+ "\n");

    }
    public static void main(String[] args) {
        Task1 t = new Task1();
        final double batteryPower = 35.8;
        double current, voltage, chargingEfficiency, chardingTime;
        System.out.print("Power(A)\tCurrent(V)\tCharging efficiency(kW)\tChargingtime(h)\n");
        current = 10;
        voltage = 230;
        if(voltage == 230) // if voltage is 230 then single phase power function is called
        {
            chargingEfficiency = t.singlePhasePower(voltage, current);
            chardingTime = batteryPower/chargingEfficiency;
            chardingTime = t.ConvertToTwoDecimalPlaces(chardingTime);
            t.priting(voltage,current, chargingEfficiency,chardingTime);
        }
        else if(voltage == 400) // if voltage is 230 then three phase power function is called
        {
            chargingEfficiency = t.ThreePhasePower(voltage, current);
            chardingTime = batteryPower/chargingEfficiency;
            chardingTime = t.ConvertToTwoDecimalPlaces(chardingTime);
            t.priting(voltage,current, chargingEfficiency,chardingTime);
        }
        current = 16;
        voltage = 230;
        if(voltage == 230)
        {
            chargingEfficiency = t.singlePhasePower(voltage, current);
            chardingTime = batteryPower/chargingEfficiency;
            chardingTime = t.ConvertToTwoDecimalPlaces(chardingTime);
            t.priting(voltage,current, chargingEfficiency,chardingTime);
        }
        else if(voltage == 400)
        {
            chargingEfficiency = t.ThreePhasePower(voltage, current);
            chardingTime = batteryPower/chargingEfficiency;
            chardingTime = t.ConvertToTwoDecimalPlaces(chardingTime);
            t.priting(voltage,current, chargingEfficiency,chardingTime);
        }
        current = 10;
        voltage = 400;
        if(voltage == 230)
        {
            chargingEfficiency = t.singlePhasePower(voltage, current);
            chardingTime = batteryPower/chargingEfficiency;
            chardingTime = t.ConvertToTwoDecimalPlaces(chardingTime);
            t.priting(voltage,current, chargingEfficiency,chardingTime);
        }
        else if(voltage == 400)
        {
            chargingEfficiency = t.ThreePhasePower(voltage, current);
            chardingTime = batteryPower/chargingEfficiency;
            chardingTime = t.ConvertToTwoDecimalPlaces(chardingTime);
            t.priting(voltage,current, chargingEfficiency,chardingTime);
        }
        current = 16;
        voltage = 400;
        if(voltage == 230)
        {
            chargingEfficiency = t.singlePhasePower(voltage, current);
            chardingTime = batteryPower/chargingEfficiency;
            chardingTime = t.ConvertToTwoDecimalPlaces(chardingTime);
            t.priting(voltage,current, chargingEfficiency,chardingTime);
        }
        else if(voltage == 400)
        {
            chargingEfficiency = t.ThreePhasePower(voltage, current);
            chardingTime = batteryPower/chargingEfficiency;
            chardingTime = t.ConvertToTwoDecimalPlaces(chardingTime);
            t.priting(voltage,current, chargingEfficiency,chardingTime);
        }
        current = 32;
        voltage = 400;
        if(voltage == 230)
        {
            chargingEfficiency = t.singlePhasePower(voltage, current);
            chardingTime = batteryPower/chargingEfficiency;
            chardingTime = t.ConvertToTwoDecimalPlaces(chardingTime);
            t.priting(voltage,current, chargingEfficiency,chardingTime);
        }
        else if(voltage == 400)
        {
            chargingEfficiency = t.ThreePhasePower(voltage, current);
            chardingTime = batteryPower/chargingEfficiency;
            chardingTime = t.ConvertToTwoDecimalPlaces(chardingTime);
            t.priting(voltage,current, chargingEfficiency,chardingTime);
        }
    }
}
