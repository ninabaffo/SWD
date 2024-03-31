/**
 * This Class converts the English inputted value to its Metric conversion.
 *
 */
public class English2Metric {
    private String convertPhrase;

    English2Metric(String myPhrase) {
        this.convertPhrase = myPhrase;
    }

    /**
     * Splits up the given string to convert. Then takes the English value and
     * compares it to the Metric value. If they are the same unit, then calls the according
     * function to Convert the english value to metric.
     */
    public void convertToUnits() {
        convertPhrase.toLowerCase();
        String str1[] = convertPhrase.split(" ");
        int yVal = Integer.parseInt(str1[5]);
        String convertTo = str1[2];
        String convertFrom = str1[6];

        if ((isMetricL(convertTo) && isEnglishL(convertFrom))) {
            getLength(convertTo, convertFrom, yVal);
        } else if (isMetricM(convertTo) && isEnglishM(convertFrom)) {
            getMass(convertTo, convertFrom, yVal);
        } else if (isMetricV(convertTo) && isEnglishV(convertFrom)) {
            getVolume(convertTo, convertFrom, yVal);
        } else {
            System.out.println("PLease enter a valid conversion statement.");
        }
    }

    /**
     * Takes the string and makes sure that it is in metric units of Length.
     * @param metricUnit the string to check.
     * @return true if metricUnit is a metric unit of type length and false if otherwise.
     */
    public boolean isMetricL(String metricUnit) {
        if (metricUnit.equals("millimeters") || metricUnit.equals("centimeters")
                || metricUnit.equals("meters") || metricUnit.equals("kilometers")) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Takes the string and makes sure that it is in English units of Length.
     * @param englishUnit the string to check.
     * @return true if englishUnit is a metric unit of type length and false if otherwise.
     */
    public boolean isEnglishL(String englishUnit) {
        if (englishUnit.equals("inches") || englishUnit.equals("feet")
                || englishUnit.equals("miles") || englishUnit.equals("yards")) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Takes the metric string and multiplies the english string by yVal then converts to metric.
     * @param english the english unit string
     * @param metric the metric unit string
     * @param yVal - the amount to multiply by in terms of how many (metricUnits are in x english units)
     * @return a double with the conversion and outputs a phrase with the conversion.
     */
    public double getLength(String metric, String english, int yVal) {
        double endVal = 0;
        if (english.equals("inches")) {
            if (metric.equals("millimeters")) {
                endVal = 25.4*yVal;
            } else if (metric.equals("centimeters")) {
                endVal = 2.54*yVal;
            } else if (metric.equals("meters")) {
                endVal = 0.0254*yVal;
            } else if (metric.equals("kilometers")) {
                endVal = 0.0000254*yVal;
            }
        } else if (english.equals("feet")) {
            if (metric.equals("millimeters")) {
                endVal = 304.8*yVal;
            } else if (metric.equals("centimeters")) {
                endVal = 30.48*yVal;
            } else if (metric.equals("meters")) {
                endVal =0.3048*yVal;
            } else if (metric.equals("kilometers")) {
                endVal =.0003048*yVal;
            }
        } else if (english.equals("yards")) {
            if (metric.equals("millimeters")) {
                endVal =914.4*yVal;
            } else if (metric.equals("centimeters")) {
                endVal =91.44*yVal;
            } else if (metric.equals("meters")) {
                endVal =0.9144*yVal;
            } else if (metric.equals("kilometers")) {
                endVal =.0009144*yVal;
            }
        } else if (english.equals("miles")) {
            if (metric.equals("millimeters")) {
                endVal =.000001609*yVal;
            } else if (metric.equals("centimeters")) {
                endVal = 160934*yVal;
            } else if (metric.equals("meters")) {
                endVal = (1609.34*yVal);
            } else if (metric.equals("kilometers")) {
                endVal =1.60934*yVal;
            }
        }
        System.out.println("There are " + endVal + " " + metric + " in " + yVal + " " + english);
        return endVal;
    }
    /**
     * Takes the string and makes sure that it is in metric units of Mass.
     * @param metricUnit the string to check.
     * @return true if metricUnit is a metric unit of type mass and false if otherwise.
     */
    public boolean isMetricM(String metricUnit) {
        if (metricUnit.equals("grams") || metricUnit.equals("kilograms") || metricUnit.equals("tons")) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Takes the string and makes sure that it is in English units of Mass.
     * @param englishUnit the string to check.
     * @return true if englishUnit is a metric unit of type mass and false if otherwise.
     */
    public boolean isEnglishM(String englishUnit) {
        if (englishUnit.equals("ounces") || englishUnit.equals("pounds") || englishUnit.equals("kilograms")) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Takes the metric string and multiplies the english string by yVal then converts to metric.
     * @param english the english unit string
     * @param metric the metric unit string
     * @param yVal - the amount to multiply by in terms of how many (metricUnits are in x english units)
     * @return a double with the conversion and outputs a phrase with the conversion.
     */
    private double getMass(String metric, String english, int yVal) {
        double endVal = 0;
        double kilograms = .02834; // 1 oz = .02834 kilograms
        double tons = .0000279; // 1 oz = .000279 tons

        if (english.equals("ounces")) {
            if (metric.equals("grams")) {
                endVal = 28.3495 * yVal;
            } else if (metric.equals("kilograms")) {
                endVal = 0.02834 * yVal;
            } else if (metric.equals("tons")) {
                endVal = 0.0000279 * yVal;
            }
        } else if (english.equals("pounds")) {
            if (metric.equals("grams")) {
                endVal = 453.592 * yVal;
            } else if (metric.equals("kilograms")) {
                endVal = 0.453592 * yVal;
            } else if (metric.equals("tons")) {
                endVal = .0004536 * yVal;
            }
        }
        System.out.println("There are " + endVal + " " + metric + " in " + yVal + " " + english);
        return endVal;
    }
    /**
     * Takes the string and makes sure that it is in metric units of Volume.
     * @param metricUnit the string to check.
     * @return true if metricUnit is a metric unit of type volume and false if otherwise.
     */
    public boolean isMetricV(String metricUnit) {
        if (metricUnit.equals("milliliters") || metricUnit.equals("liters")) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Takes the string and makes sure that it is in english units of Volume.
     * @param englishUnit the string to check.
     * @return true if englishUnit is a metric unit of type volume and false if otherwise.
     */
    public boolean isEnglishV(String englishUnit) {
        if (englishUnit.equals("pints") || englishUnit.equals("quarts") || englishUnit.equals("gallons")) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Takes the metric string and multiplies the english string by yVal then converts to metric.
     * @param english the english unit string
     * @param metric the metric unit string
     * @param yVal - the amount to multiply by in terms of how many (metricUnits are in x english units)
     * @return a double with the conversion and outputs a phrase with the conversion.
     */
    public double getVolume(String metric, String english, int yVal) {
        double endVal = 0;

        if (english.equals("pints")) {
            if (metric.equals("milliliters")) {
                endVal = 568.261*yVal;
            } else if (metric.equals("liters")) {
                endVal = 0.5682* yVal;
            }
        } else if (english.equals("quarts")) {
            if (metric.equals("milliliters")) {
                endVal = 946.343 * yVal;
            } else if (metric.equals("liters")) {
                endVal = 0.946343 * yVal;
            }
        } else if (english.equals("gallons")) {
            if (metric.equals("milliliters")) {
                endVal = 3785.41 * yVal;
            } else if (metric.equals("liters")) {
                endVal = 3.7854 * yVal;
            }
        }
        System.out.println("There are " + endVal + " " + metric + " in " + yVal + " " + english);
        return endVal;
    }
}