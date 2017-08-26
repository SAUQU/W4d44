//package com.example.segundoauqui.w4d44;
//
//import android.app.IntentService;
//import android.content.Intent;
//import android.location.Address;
//import android.location.Geocoder;
//import android.os.ResultReceiver;
//import android.provider.SyncStateContract;
//import android.util.Log;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//
///**
// * Created by segundoauqui on 8/26/17.
// */
//
//public class GeocodeAddressIntentService extends IntentService {
//
//
//        protected ResultReceiver resultReceiver;
//        private static final String TAG = "FetchAddyIntentService";
//
//
//        public GeocodeAddressIntentService() {
//            super("GeocodeAddressIntentService");
//        }
//
//        @Override
//        protected void onHandleIntent(Intent intent) {
//            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
//            List<Address> addresses = null;
//
//            resultReceiver = intent.getParcelableExtra(SyncStateContract.Constants.RECEIVER);
//            int fetchType = intent.getIntExtra(SyncStateContract.Constants.FETCH_TYPE_EXTRA, 0);
//            if(fetchType == Constants.USE_ADDRESS_NAME) {
//                String name = intent.getStringExtra(Constants.LOCATION_NAME_DATA_EXTRA);
//                try {
//                    addresses = geocoder.getFromLocationName(name, 1);
//                } catch (IOException e) {
//                    errorMessage = "Service not available";
//                    Log.e(TAG, errorMessage, e);
//                }
//            }
//            else if(fetchType == Constants.USE_ADDRESS_LOCATION) {
//                Location location = intent.getParcelableExtra(
//                        Constants.LOCATION_DATA_EXTRA);
//
//                try {
//                    addresses = geocoder.getFromLocation(
//                            location.getLatitude(), location.getLongitude(), 1);
//                } catch (IOException ioException) {
//                    errorMessage = "Service Not Available";
//                    Log.e(TAG, errorMessage, ioException);
//                } catch (IllegalArgumentException illegalArgumentException) {
//                    errorMessage = "Invalid Latitude or Longitude Used";
//                    Log.e(TAG, errorMessage + ". " +
//                            "Latitude = " + location.getLatitude() + ", Longitude = " +
//                            location.getLongitude(), illegalArgumentException);
//                }
//            }
//            else {
//                errorMessage = "Unknown Type";
//            }
//
//            if (addresses == null || addresses.size()  == 0) {
//                if (errorMessage.isEmpty()) {
//                    errorMessage = "Not Found";
//                }
//                deliverResultToReceiver(Constants.FAILURE_RESULT, errorMessage, null);
//            } else {
//                for(Address address : addresses) {
//                    String outputAddress = "";
//                    for(int i = 0; i < address.getMaxAddressLineIndex(); i++) {
//                        outputAddress += " --- " + address.getAddressLine(i);
//                    }
//                }
//                Address address = addresses.get(0);
//                ArrayList<String> addressFragments = new ArrayList<String>();
//
//                for(int i = 0; i < address.getMaxAddressLineIndex(); i++) {
//                    addressFragments.add(address.getAddressLine(i));
//                }
//                (R.string.address_found));
//                deliverResultToReceiver(Constants.SUCCESS_RESULT,
//                        TextUtils.join(System.getProperty("line.separator"),
//                                addressFragments), address);
//            }
//
//        }
//
//    private void deliverResultToReceiver(int resultCode, String message, Address address) {
//        Bundle bundle = new Bundle();
//        bundle.putParcelable(Constants.RESULT_ADDRESS, address);
//        bundle.putString(Constants.RESULT_DATA_KEY, message);
//        resultReceiver.send(resultCode, bundle);
//    }
//}
//
