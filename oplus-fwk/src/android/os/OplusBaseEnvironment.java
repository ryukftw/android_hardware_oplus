package android.os;

import java.io.File;

/* renamed from: android.os.OplusBaseEnvironment */
/* loaded from: classes2.dex */
public class OplusBaseEnvironment {
    private static final String DIR_OPLUS_RESERVE = "/mnt/vendor/oplusreserve";
    private static final String ENV_MY_BIGBALL_ROOT = "MY_BIGBALL_ROOT";
    private static final String ENV_MY_CARRIER_ROOT = "MY_CARRIER_ROOT";
    private static final String ENV_MY_COMPANY_ROOT = "MY_COMPANY_ROOT";
    private static final String ENV_MY_COUNTRY_ROOT = "MY_REGION_ROOT";
    private static final String ENV_MY_ENGINEER_ROOT = "MY_ENGINEERING_ROOT";
    private static final String ENV_MY_HEYTAP_ROOT = "MY_HEYTAP_ROOT";
    private static final String ENV_MY_OPERATOR_ROOT = "MY_CARRIER_ROOT";
    private static final String ENV_MY_PRELOAD_ROOT = "MY_PRELOAD_ROOT";
    private static final String ENV_MY_PRODUCT_ROOT = "MY_PRODUCT_ROOT";
    private static final String ENV_MY_REGION_ROOT = "MY_REGION_ROOT";
    private static final String ENV_MY_STOCK_ROOT = "MY_STOCK_ROOT";
    private static final String ENV_OPLUS_CUSTOM_ROOT = "MY_CUSTOM_ROOT";
    private static final String ENV_OPLUS_ENGINEER_ROOT = "MY_ENGINEERING_ROOT";
    private static final String ENV_OPLUS_OPERATOR_ROOT = "MY_OPERATOR_ROOT";
    private static final String ENV_OPLUS_PRODUCT_ROOT = "MY_PRODUCT_ROOT";
    private static final String ENV_OPLUS_VERSION_ROOT = "MY_VERSION_ROOT";
    public static final boolean NOT_ALLOW_EXT4_ACCESS = true;
    private static File sDirMyBigballRoot = null;
    private static File DIR_MY_PRELOAD_ROOT = null;
    private static File DIR_MY_HEYTAP_ROOT = null;
    private static File DIR_MY_STOCK_ROOT = null;
    private static File DIR_MY_PRODUCT_ROOT = null;
    private static File DIR_MY_COUNTRY_ROOT = null;
    private static File DIR_MY_REGION_ROOT = null;
    private static File DIR_MY_OPERATOR_ROOT = null;
    private static File DIR_MY_CARRIER_ROOT = null;
    private static File DIR_MY_COMPANY_ROOT = null;
    private static File DIR_MY_ENGINEER_ROOT = null;
    private static File sDIROPLUSVERSIONROOT = null;
    private static File sDIROPLUSPRODUCTROOT = null;
    private static File sDIROPLUSENGINEERROOT = null;
    private static File sDIROPLUSOPERATORROOT = null;
    private static File sDIROPLUSCUSTOMROOT = null;

    public static File getReserveDirectory() {
        return new File(DIR_OPLUS_RESERVE);
    }

    public static boolean isWhiteListMcp() {
        return false;
    }

    protected static File getDirectorySup(String variableName, String defaultPath) {
        String path = System.getenv(variableName);
        return path == null ? new File(defaultPath) : new File(path);
    }

    public static File getOplusCustomDirectory() {
        if (sDIROPLUSCUSTOMROOT == null) {
            sDIROPLUSCUSTOMROOT = getDirectorySup(ENV_OPLUS_CUSTOM_ROOT, "/my_company");
        }
        return sDIROPLUSCUSTOMROOT;
    }

    public static File getOplusCotaDirectory() {
        if (sDIROPLUSOPERATORROOT == null) {
            sDIROPLUSOPERATORROOT = getDirectorySup(ENV_OPLUS_OPERATOR_ROOT, "/my_operator");
        }
        return sDIROPLUSOPERATORROOT;
    }

    public static boolean isOplusCustomDirectoryEmpty() {
        File file = getOplusCustomDirectory();
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            return false;
        }
        return true;
    }

    public static boolean isOplusCotaDirectoryEmpty() {
        File file = getOplusCotaDirectory();
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            return false;
        }
        return true;
    }

    public static File getResourceDirectory() {
        if (!isOplusCustomDirectoryEmpty()) {
            return getOplusCustomDirectory();
        }
        if (!isOplusCotaDirectoryEmpty()) {
            return getOplusCotaDirectory();
        }
        return getOplusCustomDirectory();
    }

    public static File getOplusProductDirectory() {
        if (sDIROPLUSPRODUCTROOT == null) {
            sDIROPLUSPRODUCTROOT = getDirectorySup("MY_PRODUCT_ROOT", "/oplus_product");
        }
        return sDIROPLUSPRODUCTROOT;
    }

    public static File getOplusEngineerDirectory() {
        if (sDIROPLUSENGINEERROOT == null) {
            sDIROPLUSENGINEERROOT = getDirectorySup("MY_ENGINEERING_ROOT", "/oplus_engineering");
        }
        return sDIROPLUSENGINEERROOT;
    }

    public static File getOplusVersionDirectory() {
        if (sDIROPLUSVERSIONROOT == null) {
            sDIROPLUSVERSIONROOT = getDirectorySup(ENV_OPLUS_VERSION_ROOT, "/oplus_version");
        }
        return sDIROPLUSVERSIONROOT;
    }

    public static File getMyPreloadDirectory() {
        if (DIR_MY_PRELOAD_ROOT == null) {
            DIR_MY_PRELOAD_ROOT = getDirectorySup(ENV_MY_PRELOAD_ROOT, "/my_preload");
        }
        return DIR_MY_PRELOAD_ROOT;
    }

    public static File getMyBigballDirectory() {
        if (sDirMyBigballRoot == null) {
            sDirMyBigballRoot = getDirectorySup(ENV_MY_BIGBALL_ROOT, "/my_bigball");
        }
        return sDirMyBigballRoot;
    }

    public static File getMyHeytapDirectory() {
        if (DIR_MY_HEYTAP_ROOT == null) {
            DIR_MY_HEYTAP_ROOT = getDirectorySup(ENV_MY_HEYTAP_ROOT, "/my_heytap");
        }
        return DIR_MY_HEYTAP_ROOT;
    }

    public static File getMyStockDirectory() {
        if (DIR_MY_STOCK_ROOT == null) {
            DIR_MY_STOCK_ROOT = getDirectorySup(ENV_MY_STOCK_ROOT, "/my_stock");
        }
        return DIR_MY_STOCK_ROOT;
    }

    public static File getMyProductDirectory() {
        if (DIR_MY_PRODUCT_ROOT == null) {
            DIR_MY_PRODUCT_ROOT = getDirectorySup("MY_PRODUCT_ROOT", "/my_product");
        }
        return DIR_MY_PRODUCT_ROOT;
    }

    public static File getMyCountryDirectory() {
        if (DIR_MY_COUNTRY_ROOT == null) {
            DIR_MY_COUNTRY_ROOT = getDirectorySup("MY_REGION_ROOT", "/my_region");
        }
        return DIR_MY_COUNTRY_ROOT;
    }

    public static File getMyRegionDirectory() {
        if (DIR_MY_REGION_ROOT == null) {
            DIR_MY_REGION_ROOT = getDirectorySup("MY_REGION_ROOT", "/my_region");
        }
        return DIR_MY_REGION_ROOT;
    }

    public static File getMyOperatorDirectory() {
        if (DIR_MY_OPERATOR_ROOT == null) {
            DIR_MY_OPERATOR_ROOT = getDirectorySup("MY_CARRIER_ROOT", "/my_carrier");
        }
        return DIR_MY_OPERATOR_ROOT;
    }

    public static File getMyCarrierDirectory() {
        if (DIR_MY_CARRIER_ROOT == null) {
            DIR_MY_CARRIER_ROOT = getDirectorySup("MY_CARRIER_ROOT", "/my_carrier");
        }
        return DIR_MY_CARRIER_ROOT;
    }

    public static File getMyCompanyDirectory() {
        if (DIR_MY_COMPANY_ROOT == null) {
            DIR_MY_COMPANY_ROOT = getDirectorySup(ENV_MY_COMPANY_ROOT, "/my_company");
        }
        return DIR_MY_COMPANY_ROOT;
    }

    public static File getMyEngineeringDirectory() {
        if (DIR_MY_ENGINEER_ROOT == null) {
            DIR_MY_ENGINEER_ROOT = getDirectorySup("MY_ENGINEERING_ROOT", "/my_engineering");
        }
        return DIR_MY_ENGINEER_ROOT;
    }
}
