package com.parata.constants;

/**
 * @author MFU
 * 10/12/2020
 */
public class QUERIES {

    public static final String READMODE = "SELECT \"Id\", \"Name\", \"Automode\" FROM public.\"ConsumerGroup\" where \"Name\"='atpstdvm';";
    public static final String ASSETCOUNTGAYCO ="SELECT Count (*) FROM public.\"OrgAsset\" where \"OrganizationId\"=";
    public static final String ENABLEDASSETCOUNTGAYCO ="SELECT Count (*) FROM public.\"OrgAsset\" where \"Enabled\"='true' and \"OrganizationId\"=";
    public static final String SITECOUNTGAYCO="SELECT Count (*) FROM public.\"Organization\" where \"Is_Parent_Account\"='false' and \"Parent_Account_Id\"=";
    public static final String ACTIVESITECOUNTGAYCO="SELECT Count (*) FROM public.\"Organization\" where \"Is_Parent_Account\"='false' and \"Parent_Account_Id\"=";
    public static final String USERID="\tSELECT \"UserId\", \"FirstName\", \"LastName\", \"UserName\", \"Auth0UserId\", \"Email\", \"EULA_Accepted\", \"EULA_Accepted_On\", \"LastActionDoneBy\", \"Enabled\", \"LastActionDoneOn\", \"LastActionDone\"\n" +
            "\tFROM public.\"User\" where \"Email\"=";
    public static final String SYSTEMCOUNTFORDUBLIN="SELECT count (*) FROM public.\"OrgAsset\" where \"Enabled\"='true' and \"OrganizationId\"=";
    public static final String ORGIDFORGAYCODUBLIN="SELECT \"OrganizationId\", \"Name\", \"Is_Parent_Account\", \"Parent_Account_Id\", \"Parata_IM\", \"Primary_Org_Admin\", \"Parata_Support_Person\", \"StartTime\", \"ClosingTime\", \"OrgStatusId\", \"SalesforceId\", \"CustomerNo\", \"SalesforceName\", \"IsInternal\", \"LastActionDoneBy\", \"Enabled\", \"LastActionDoneOn\", \"LastActionDone\"\n" +
            "\tFROM public.\"Organization\" where \"Name\"='Dublin';";
    public static final String ORGIDFORGAYCO="SELECT \"OrganizationId\", \"Name\", \"Is_Parent_Account\", \"Parent_Account_Id\", \"Parata_IM\", \"Primary_Org_Admin\", \"Parata_Support_Person\", \"StartTime\", \"ClosingTime\", \"OrgStatusId\", \"SalesforceId\", \"CustomerNo\", \"SalesforceName\", \"IsInternal\", \"LastActionDoneBy\", \"Enabled\", \"LastActionDoneOn\", \"LastActionDone\"\n" +
            "\tFROM public.\"Organization\" where \"Name\"='Gayco';";
    public static final String COUNTOFEXTERNALROLES="SELECT count (*) FROM public.\"Role\" where \"IsInternal\"='false'";
    public static final String ASSETIDFORGAYCO="SELECT \"OrganizationId\", \"AssetId\", \"Asset_Owner\", \"LastActionDoneBy\", \"Enabled\", \"LastActionDoneOn\", \"LastActionDone\"\n" +
            "\tFROM public.\"OrgAsset\" where \"OrganizationId\"='a6dfae1f-2258-472b-92bd-be0a6d3c79dd' and \"Enabled\"='true'";
    public static final String ASSETNAMEFORGAYCO="SELECT \"AssetId\", \"AssetTypeId\", \"Name\", \"Description\", \"Configurations\", \"MachineNo\", \"LastActionDoneBy\", \"Enabled\", \"LastActionDoneOn\", \"LastActionDone\"\n" +
            "\tFROM public.\"Asset\" where \"AssetId\"=";

    public static final  String ACTIVATEUSER="UPDATE public.\"User\" SET  \"Enabled\"='true' WHERE \"Email\"=";
    public static final String CLEARUSERSETTINGS="UPDATE public.\"UserConfiguration\" SET  \"PPWidgetConfig\"='[]' WHERE \"UserId\"=";

    public static final String DELETETESTNOTIFICATIONDATA="Delete from public.\"UserNotificationConfig\" where \"Recipients\"=";

    public static final String COUNTFORNOTIFICATION="Select count (*) FROM public.\"UserNotificationConfig\" where \"Recipients\"=";




}
