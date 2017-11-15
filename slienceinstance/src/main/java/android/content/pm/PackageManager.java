package android.content.pm;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AndroidException;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public abstract class PackageManager
{
    public static final int GET_ACTIVITIES = 1;
    public static final int GET_RECEIVERS = 2;
    public static final int GET_SERVICES = 4;
    public static final int GET_PROVIDERS = 8;
    public static final int GET_INSTRUMENTATION = 16;
    public static final int GET_INTENT_FILTERS = 32;
    public static final int GET_SIGNATURES = 64;
    public static final int GET_RESOLVED_FILTER = 64;
    public static final int GET_META_DATA = 128;
    public static final int GET_GIDS = 256;
    public static final int GET_DISABLED_COMPONENTS = 512;
    public static final int GET_SHARED_LIBRARY_FILES = 1024;
    public static final int GET_URI_PERMISSION_PATTERNS = 2048;
    public static final int GET_PERMISSIONS = 4096;
    public static final int GET_UNINSTALLED_PACKAGES = 8192;
    public static final int GET_CONFIGURATIONS = 16384;
    public static final int MATCH_DEFAULT_ONLY = 65536;
    public static final int PERMISSION_GRANTED = 0;
    public static final int PERMISSION_DENIED = -1;
    public static final int SIGNATURE_MATCH = 0;
    public static final int SIGNATURE_NEITHER_SIGNED = 1;
    public static final int SIGNATURE_FIRST_NOT_SIGNED = -1;
    public static final int SIGNATURE_SECOND_NOT_SIGNED = -2;
    public static final int SIGNATURE_NO_MATCH = -3;
    public static final int SIGNATURE_UNKNOWN_PACKAGE = -4;
    public static final int COMPONENT_ENABLED_STATE_DEFAULT = 0;
    public static final int COMPONENT_ENABLED_STATE_ENABLED = 1;
    public static final int COMPONENT_ENABLED_STATE_DISABLED = 2;
    public static final int COMPONENT_ENABLED_STATE_DISABLED_USER = 3;
    public static final int INSTALL_FORWARD_LOCK = 1;
    public static final int INSTALL_REPLACE_EXISTING = 2;
    public static final int INSTALL_ALLOW_TEST = 4;
    public static final int INSTALL_EXTERNAL = 8;
    public static final int INSTALL_INTERNAL = 16;
    public static final int INSTALL_FROM_ADB = 32;
    public static final int INSTALL_ALL_USERS = 64;
    public static final int INSTALL_ALLOW_DOWNGRADE = 128;
    public static final int INSTALL_GRANT_RUNTIME_PERMISSIONS = 256;
    public static final int INSTALL_FORCE_VOLUME_UUID = 512;
    public static final int INSTALL_FORCE_PERMISSION_PROMPT = 1024;
    public static final int INSTALL_EPHEMERAL = 2048;
    public static final int INSTALL_DONT_KILL_APP = 4096;
    public static final int INSTALL_FORCE_SDK = 8192;
    public static final int DONT_KILL_APP = 1;
    public static final int INSTALL_SUCCEEDED = 1;
    public static final int INSTALL_FAILED_ALREADY_EXISTS = -1;
    public static final int INSTALL_FAILED_INVALID_APK = -2;
    public static final int INSTALL_FAILED_INVALID_URI = -3;
    public static final int INSTALL_FAILED_INSUFFICIENT_STORAGE = -4;
    public static final int INSTALL_FAILED_DUPLICATE_PACKAGE = -5;
    public static final int INSTALL_FAILED_NO_SHARED_USER = -6;
    public static final int INSTALL_FAILED_UPDATE_INCOMPATIBLE = -7;
    public static final int INSTALL_FAILED_SHARED_USER_INCOMPATIBLE = -8;
    public static final int INSTALL_FAILED_MISSING_SHARED_LIBRARY = -9;
    public static final int INSTALL_FAILED_REPLACE_COULDNT_DELETE = -10;
    public static final int INSTALL_FAILED_DEXOPT = -11;
    public static final int INSTALL_FAILED_OLDER_SDK = -12;
    public static final int INSTALL_FAILED_CONFLICTING_PROVIDER = -13;
    public static final int INSTALL_FAILED_NEWER_SDK = -14;
    public static final int INSTALL_FAILED_TEST_ONLY = -15;
    public static final int INSTALL_FAILED_CPU_ABI_INCOMPATIBLE = -16;
    public static final int INSTALL_FAILED_MISSING_FEATURE = -17;
    public static final int INSTALL_FAILED_CONTAINER_ERROR = -18;
    public static final int INSTALL_FAILED_INVALID_INSTALL_LOCATION = -19;
    public static final int INSTALL_FAILED_MEDIA_UNAVAILABLE = -20;
    public static final int INSTALL_FAILED_VERIFICATION_TIMEOUT = -21;
    public static final int INSTALL_FAILED_VERIFICATION_FAILURE = -22;
    public static final int INSTALL_FAILED_PACKAGE_CHANGED = -23;
    public static final int INSTALL_PARSE_FAILED_NOT_APK = -100;
    public static final int INSTALL_PARSE_FAILED_BAD_MANIFEST = -101;
    public static final int INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION = -102;
    public static final int INSTALL_PARSE_FAILED_NO_CERTIFICATES = -103;
    public static final int INSTALL_PARSE_FAILED_INCONSISTENT_CERTIFICATES = -104;
    public static final int INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING = -105;
    public static final int INSTALL_PARSE_FAILED_BAD_PACKAGE_NAME = -106;
    public static final int INSTALL_PARSE_FAILED_BAD_SHARED_USER_ID = -107;
    public static final int INSTALL_PARSE_FAILED_MANIFEST_MALFORMED = -108;
    public static final int INSTALL_PARSE_FAILED_MANIFEST_EMPTY = -109;
    public static final int INSTALL_FAILED_INTERNAL_ERROR = -110;
    public static final int DONT_DELETE_DATA = 1;
    public static final int DELETE_SUCCEEDED = 1;
    public static final int DELETE_FAILED_INTERNAL_ERROR = -1;
    public static final int DELETE_FAILED_DEVICE_POLICY_MANAGER = -2;
    public static final int MOVE_SUCCEEDED = 1;
    public static final int MOVE_FAILED_INSUFFICIENT_STORAGE = -1;
    public static final int MOVE_FAILED_DOESNT_EXIST = -2;
    public static final int MOVE_FAILED_SYSTEM_PACKAGE = -3;
    public static final int MOVE_FAILED_FORWARD_LOCKED = -4;
    public static final int MOVE_FAILED_INVALID_LOCATION = -5;
    public static final int MOVE_FAILED_INTERNAL_ERROR = -6;
    public static final int MOVE_FAILED_OPERATION_PENDING = -7;
    public static final int MOVE_INTERNAL = 1;
    public static final int MOVE_EXTERNAL_MEDIA = 2;
    public static final int VERIFICATION_ALLOW_WITHOUT_SUFFICIENT = 2;
    public static final int VERIFICATION_ALLOW = 1;
    public static final int VERIFICATION_REJECT = -1;
    public static final int PER_USER_RANGE = 100000;
    public static final String FEATURE_LIVE_WALLPAPER = "android.software.live_wallpaper";
    public static final String FEATURE_WIFI = "android.hardware.wifi";
    public static final String FEATURE_WIFI_DIRECT = "android.hardware.wifi.direct";
    public static final String ACTION_CLEAN_EXTERNAL_STORAGE = "android.content.pm.CLEAN_EXTERNAL_STORAGE";
    public static final String EXTRA_VERIFICATION_URI = "android.content.pm.extra.VERIFICATION_URI";
    public static final String EXTRA_VERIFICATION_ID = "android.content.pm.extra.VERIFICATION_ID";
    public static final String EXTRA_VERIFICATION_INSTALLER_PACKAGE = "android.content.pm.extra.VERIFICATION_INSTALLER_PACKAGE";
    public static final String EXTRA_VERIFICATION_INSTALL_FLAGS = "android.content.pm.extra.VERIFICATION_INSTALL_FLAGS";
    public abstract PackageInfo getPackageInfo(String paramString, int paramInt)
            throws PackageManager.NameNotFoundException;

    public abstract String[] currentToCanonicalPackageNames(String[] paramArrayOfString);

    public abstract String[] canonicalToCurrentPackageNames(String[] paramArrayOfString);

    public abstract Intent getLaunchIntentForPackage(String paramString);

    public abstract int[] getPackageGids(String paramString)
            throws PackageManager.NameNotFoundException;

    public abstract PermissionInfo getPermissionInfo(String paramString, int paramInt)
            throws PackageManager.NameNotFoundException;

    public abstract List<PermissionInfo> queryPermissionsByGroup(String paramString, int paramInt)
            throws PackageManager.NameNotFoundException;

    public abstract PermissionGroupInfo getPermissionGroupInfo(String paramString, int paramInt)
            throws PackageManager.NameNotFoundException;

    public abstract List<PermissionGroupInfo> getAllPermissionGroups(int paramInt);

    public abstract ApplicationInfo getApplicationInfo(String paramString, int paramInt)
            throws PackageManager.NameNotFoundException;

    public abstract ActivityInfo getActivityInfo(ComponentName paramComponentName, int paramInt)
            throws PackageManager.NameNotFoundException;

    public abstract ActivityInfo getReceiverInfo(ComponentName paramComponentName, int paramInt)
            throws PackageManager.NameNotFoundException;

    public abstract ServiceInfo getServiceInfo(ComponentName paramComponentName, int paramInt)
            throws PackageManager.NameNotFoundException;

    public abstract ProviderInfo getProviderInfo(ComponentName paramComponentName, int paramInt)
            throws PackageManager.NameNotFoundException;

    public abstract List<PackageInfo> getInstalledPackages(int paramInt);

    public abstract int checkPermission(String paramString1, String paramString2);

    public abstract boolean addPermission(PermissionInfo paramPermissionInfo);

    public abstract boolean addPermissionAsync(PermissionInfo paramPermissionInfo);

    public abstract void removePermission(String paramString);

    public abstract int checkSignatures(String paramString1, String paramString2);

    public abstract int checkSignatures(int paramInt1, int paramInt2);

    public abstract String[] getPackagesForUid(int paramInt);

    public abstract String getNameForUid(int paramInt);

    public abstract int getUidForSharedUser(String paramString)
            throws PackageManager.NameNotFoundException;

    public abstract List<ApplicationInfo> getInstalledApplications(int paramInt);

    public abstract String[] getSystemSharedLibraryNames();

    public abstract FeatureInfo[] getSystemAvailableFeatures();

    public abstract boolean hasSystemFeature(String paramString);

    public abstract ResolveInfo resolveActivity(Intent paramIntent, int paramInt);

    public abstract List<ResolveInfo> queryIntentActivities(Intent paramIntent, int paramInt);

    public abstract List<ResolveInfo> queryIntentActivityOptions(ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt);

    public abstract List<ResolveInfo> queryBroadcastReceivers(Intent paramIntent, int paramInt);

    public abstract ResolveInfo resolveService(Intent paramIntent, int paramInt);

    public abstract List<ResolveInfo> queryIntentServices(Intent paramIntent, int paramInt);

    public abstract ProviderInfo resolveContentProvider(String paramString, int paramInt);

    public abstract List<ProviderInfo> queryContentProviders(String paramString, int paramInt1, int paramInt2);

    public abstract InstrumentationInfo getInstrumentationInfo(ComponentName paramComponentName, int paramInt)
            throws PackageManager.NameNotFoundException;

    public abstract List<InstrumentationInfo> queryInstrumentation(String paramString, int paramInt);

    public abstract Drawable getDrawable(String paramString, int paramInt, ApplicationInfo paramApplicationInfo);

    public abstract Drawable getActivityIcon(ComponentName paramComponentName)
            throws PackageManager.NameNotFoundException;

    public abstract Drawable getActivityIcon(Intent paramIntent)
            throws PackageManager.NameNotFoundException;

    public abstract Drawable getDefaultActivityIcon();

    public abstract Drawable getApplicationIcon(ApplicationInfo paramApplicationInfo);

    public abstract Drawable getApplicationIcon(String paramString)
            throws PackageManager.NameNotFoundException;

    public abstract Drawable getActivityLogo(ComponentName paramComponentName)
            throws PackageManager.NameNotFoundException;

    public abstract Drawable getActivityLogo(Intent paramIntent)
            throws PackageManager.NameNotFoundException;

    public abstract Drawable getApplicationLogo(ApplicationInfo paramApplicationInfo);

    public abstract Drawable getApplicationLogo(String paramString)
            throws PackageManager.NameNotFoundException;

    public abstract CharSequence getText(String paramString, int paramInt, ApplicationInfo paramApplicationInfo);

    public abstract XmlResourceParser getXml(String paramString, int paramInt, ApplicationInfo paramApplicationInfo);

    public abstract CharSequence getApplicationLabel(ApplicationInfo paramApplicationInfo);

    public abstract Resources getResourcesForActivity(ComponentName paramComponentName)
            throws PackageManager.NameNotFoundException;

    public abstract Resources getResourcesForApplication(ApplicationInfo paramApplicationInfo)
            throws PackageManager.NameNotFoundException;

    public abstract Resources getResourcesForApplication(String paramString)
            throws PackageManager.NameNotFoundException;

    @Retention(RetentionPolicy.SOURCE)
    public static @interface InstallFlags {}

    public static class NameNotFoundException
            extends AndroidException
    {
        public NameNotFoundException() {}

        public NameNotFoundException(String name)
        {
            super();
        }
    }

    public PackageInfo getPackageArchiveInfo(String archiveFilePath, int flags)
    {
        throw new RuntimeException("sub");
    }

    public abstract void installPackage(Uri paramUri, IPackageInstallObserver paramIPackageInstallObserver, int paramInt, String paramString);

    public abstract void installPackageWithVerification(Uri paramUri1, IPackageInstallObserver paramIPackageInstallObserver, int paramInt, String paramString, Uri paramUri2, ManifestDigest paramManifestDigest);

    public abstract void verifyPendingInstall(int paramInt1, int paramInt2);

    public abstract void setInstallerPackageName(String paramString1, String paramString2);

    public abstract void deletePackage(String paramString, IPackageDeleteObserver paramIPackageDeleteObserver, int paramInt);

    public abstract String getInstallerPackageName(String paramString);

    public abstract void clearApplicationUserData(String paramString, IPackageDataObserver paramIPackageDataObserver);

    public abstract void deleteApplicationCacheFiles(String paramString, IPackageDataObserver paramIPackageDataObserver);

    public abstract void freeStorageAndNotify(long paramLong, IPackageDataObserver paramIPackageDataObserver);

    public abstract void freeStorage(long paramLong, IntentSender paramIntentSender);

    public abstract void getPackageSizeInfo(String paramString, IPackageStatsObserver paramIPackageStatsObserver);

    @Deprecated
    public abstract void addPackageToPreferred(String paramString);

    @Deprecated
    public abstract void removePackageFromPreferred(String paramString);

    public abstract List<PackageInfo> getPreferredPackages(int paramInt);

    @Deprecated
    public abstract void addPreferredActivity(IntentFilter paramIntentFilter, int paramInt, ComponentName[] paramArrayOfComponentName, ComponentName paramComponentName);

    @Deprecated
    public abstract void replacePreferredActivity(IntentFilter paramIntentFilter, int paramInt, ComponentName[] paramArrayOfComponentName, ComponentName paramComponentName);

    public abstract void clearPackagePreferredActivities(String paramString);

    public abstract int getPreferredActivities(List<IntentFilter> paramList, List<ComponentName> paramList1, String paramString);

    public abstract void setComponentEnabledSetting(ComponentName paramComponentName, int paramInt1, int paramInt2);

    public abstract int getComponentEnabledSetting(ComponentName paramComponentName);

    public abstract void setApplicationEnabledSetting(String paramString, int paramInt1, int paramInt2);

    public abstract int getApplicationEnabledSetting(String paramString);

    public abstract boolean isSafeMode();

    public abstract void movePackage(String paramString, IPackageMoveObserver paramIPackageMoveObserver, int paramInt);

    public abstract UserInfo createUser(String paramString, int paramInt);

    public abstract List<UserInfo> getUsers();

    public abstract boolean removeUser(int paramInt);

    public abstract void updateUserName(int paramInt, String paramString);

    public abstract void updateUserFlags(int paramInt1, int paramInt2);

    public static boolean isSameUser(int uid1, int uid2)
    {
        return getUserId(uid1) == getUserId(uid2);
    }

    public static int getUserId(int uid)
    {
        return uid / 100000;
    }

    public static int getUid(int userId, int appId)
    {
        return userId * 100000 + appId % 100000;
    }

    public static int getAppId(int uid)
    {
        return uid % 100000;
    }

    public abstract VerifierDeviceIdentity getVerifierDeviceIdentity();
}
