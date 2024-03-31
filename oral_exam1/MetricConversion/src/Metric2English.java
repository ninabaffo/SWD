/**
 * This Class converts the Metric inputted value to its English conversion.
 */
public class Metric2English {
    private String conversionPhrase;
    Metric2English(String userPhrase) {
        this.conversionPhrase = userPhrase;
    }

    /**
     * Splits up the given string to convert. Then takes the Metric value and
     * compares it to the English value. If they are the same unit, then calls the according
     * function to Convert the metric value to english.
     */
    public void convertUnits() {
            conversionPhrase.toLowerCase();
            String str[] = conversionPhrase.split(" ");
            int xVal = Integer.parseInt(str[5]);
            if (isEnglishLength(str[2]) && isMetricLength(str[6])) {
                getConversionLength(str[2], str[6], xVal);
            } else if (isEnglishMass(str[2]) && isMetricMass(str[6])) {
                getConversionMass(str[2], str[6], xVal);
            }
            else if ((isEnglishVolume(str[2]) && isMetricVolume(str[6]))) {
                getConversionVolume(str[2], str[6], xVal);
            }
            else {
                System.out.println("PLease enter a valid conversion statement.");
            }
        }

    /**
     * Takes the string and makes sure that it is in metric units of Length.
     * @param inputMetricUnit the string to check.
     * @return true if inputMetricUnit is a metric unit of type length and false if otherwise.
     */
    public boolean isMetricLength(String inputMetricUnit) {
        if (inputMetricUnit.equals("millimeters") || inputMetricUnit.equals("centimeters")
                || inputMetricUnit.equals("meters") || inputMetricUnit.equals("kilometers")) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Takes the string and makes sure that it is in english units of Length.
     * @param inputEnglishUnit the string to check.
     * @return true if inputEnglishUnit is a metric unit of type length and false if otherwise.
     */
    public boolean isEnglishLength(String inputEnglishUnit) {
        if (inputEnglishUnit.equals("inches") || inputEnglishUnit.equals("feet")
                || inputEnglishUnit.equals("miles") || inputEnglishUnit.equals("yards")) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Takes the english string and multiplies the metric string by x then converts to english.
     * @param englishUnit the english unit string
     * @param metricUnit the metric unit string
     * @param x - the amount to multiply by in terms of how many (englishunits are in x metric units)
     * @return a double with the conversion and outputs a phrase with the conversion.
     */
    private double getConversionLength(String englishUnit, String metricUnit, int x) {
        double val = 0;
        // conversions in millimeters since that is the smallest of the values
        double inch = .03937; // 1mm = .03937 in
        double feet = .00328; // 1mm = .00328 feet
        double yard = .00109; //  1mm = .00109 yards
        double mile = .000000621; //  1 mm = .000000621 miles

        if (metricUnit.equals("millimeters")) {
            if (englishUnit.equals("inches")) {
                val = inch * x;
            } else if (englishUnit.equals("feet")) {
                val = feet * x;
            } else if (englishUnit.equals("yard")) {
                val = yard * x;
            } else if (englishUnit.equals("mile")) {
                val = mile * x;
            }
        } else if (metricUnit.equals("centimeters")) {
            if (englishUnit.equals("inches")) {
                val = inch * x * 10;
            } else if (englishUnit.equals("feet")) {
                val = feet * x * 10;
            } else if (englishUnit.equals("yard")) {
                val = yard * x * 10;
            } else if (englishUnit.equals("mile")) {
                val = mile * x * 10;
            }
        } else if (metricUnit.equals("meters")) {
            if (englishUnit.equals("inches")) {
                val = inch * x * 1000;
            } else if (englishUnit.equals("feet")) {
                val = feet * x * 1000;
            } else if (englishUnit.equals("yard")) {
                val = yard * x * 1000;
            } else if (englishUnit.equals("mile")) {
                val = mile * x * 1000;
            }
        } else if (metricUnit.equals("kilometers")) {
            if (englishUnit.equals("inches")) {
                val = inch * x * 1000000;
            } else if (englishUnit.equals("feet")) {
                val = feet * x * 1000000;
            } else if (englishUnit.equals("yards")) {
                val = yard * x * 1000000;
            } else if (englishUnit.equals("miles")) {
                val = mile * x * 1000000;
            }
        }
        System.out.println("There are "+val+ " " +englishUnit+ " in " +x+ " " +metricUnit);
        return val;
    }

    /**
     * Takes the string and makes sure that it is in metric units of Mass.
     * @param inputMetricUnit the string to check.
     * @return true if inputMetricUnit is a metric unit of type mass and false if otherwise.
     */
    public boolean isMetricMass(String inputMetricUnit) {
        if (inputMetricUnit.equals("grams") || inputMetricUnit.equals("kilograms") || inputMetricUnit.equals("tons")) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Takes the string and makes sure that it is in metric units of Mass.
     * @param inputEnglishUnit the string to check.
     * @return true if inputEnglishUnit is a metric unit of type mass and false if otherwise.
     */
    public boolean isEnglishMass(String inputEnglishUnit) {
        if (inputEnglishUnit.equals("ounces") || inputEnglishUnit.equals("pounds") || inputEnglishUnit.equals("kilograms")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Takes the english string and multiplies the metric string by x then converts to english.
     * @param englishUnit the english unit string
     * @param metricUnit the metric unit string
     * @param x - the amount to multiply by in terms of how many english Units are in x metric units)
     * @return a double with the conversion and outputs a phrase with the conversion.
     */
    private double getConversionMass(String englishUnit, String metricUnit, int x) {
        double val = 0;
        double ounce = 0.0353; //  1 gram = .0353 oz
        double pound = .0022; // 1 gram = .0022 lbs

        if (metricUnit.equals("grams")) {
            if (englishUnit.equals("ounces")) {
                val = ounce * x;
            } else if (englishUnit.equals("pounds")) {
                val = pound * x;
            }
        } else if (metricUnit.equals("kilograms")) {
            if (englishUnit.equals("ounces")) {
                val = ounce * x * 1000;
            } else if (englishUnit.equals("pounds")) {
                val = pound * x * 1000;
            }
        } else if (metricUnit.equals("tons")) {
            if (englishUnit.equals("ounces")) {
                val = ounce * x * 1000000;
            } else if (englishUnit.equals("pounds")) {
                val = pound * x * 1000000;
            }
        }
        System.out.println("There are "+val+ " " +englishUnit+ " in " +x+ " " +metricUnit);
        return val;
    }
    /**
     * Takes the string and makes sure that it is in metric units of Volume.
     * @param inputMetricUnit the string to check.
     * @return true if inputMetricUnit is a metric unit of type volume and false if otherwise.
     */
    public boolean isMetricVolume(String inputMetricUnit) {
        if (inputMetricUnit.equals("milliliters") || inputMetricUnit.equals("liters")) {
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * Takes the string and makes sure that it is in metric units of Volume.
     * @param inputEnglishUnit the string to check.
     * @return true if inputEnglishcUnit is a metric unit of type volume and false if otherwise.
     */
    public boolean isEnglishVolume(String inputEnglishUnit) {
        if (inputEnglishUnit.equals("pints") || inputEnglishUnit.equals("quarts") || inputEnglishUnit.equals("gallons")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Takes the english string and multiplies the metric string by x then converts to english.
     * @param englishUnit the english unit string
     * @param metricUnit the metric unit string
     * @param x - the amount to multiply by in terms of how many (englishunits are in x metric units)
     * @return a double with the conversion and outputs a phrase with the conversion.
     */
    private double getConversionVolume(String englishUnit, String metricUnit, int x) {
        double val = 0;
        double pint = .00211; //  1 mL = .00211 pints
        double quart = .00105669; // 1 mL = .00105669 quarts
        double gallon = .00026417; // 1 mL = .00026417 gallons

        if (metricUnit.equals("milliliters")) {
            if (englishUnit.equals("pints")) {
                val = pint * x;
            } else if (englishUnit.equals("quarts")) {
                val = quart * x;
            } else if (englishUnit.equals("gallons")) {
                val = gallon * x;
            }
        } else if (metricUnit.equals("liters")) {
            if (englishUnit.equals("pints")) {
                val = pint * x *1000;
            } else if (englishUnit.equals("quarts")) {
                val = quart * x *1000;
            } else if (englishUnit.equals("gallons")) {
                val = gallon * x *1000;
            }
        }
        System.out.println("There are "+val+ " " +englishUnit+ " in " +x+ " " +metricUnit);
        return val;
    }


}
