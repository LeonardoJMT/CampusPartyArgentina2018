package com.sdl.hellosdlandroid;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.example.vehicledatamodule.VehicleDataInterface;
import com.smartdevicelink.exception.SdlException;
import com.smartdevicelink.proxy.LockScreenManager;
import com.smartdevicelink.proxy.RPCRequest;
import com.smartdevicelink.proxy.RPCResponse;
import com.smartdevicelink.proxy.SdlProxyALM;
import com.smartdevicelink.proxy.callbacks.OnServiceEnded;
import com.smartdevicelink.proxy.callbacks.OnServiceNACKed;
import com.smartdevicelink.proxy.interfaces.IProxyListenerALM;
import com.smartdevicelink.proxy.rpc.AddCommand;
import com.smartdevicelink.proxy.rpc.AddCommandResponse;
import com.smartdevicelink.proxy.rpc.AddSubMenuResponse;
import com.smartdevicelink.proxy.rpc.Alert;
import com.smartdevicelink.proxy.rpc.AlertManeuverResponse;
import com.smartdevicelink.proxy.rpc.AlertResponse;
import com.smartdevicelink.proxy.rpc.ButtonPressResponse;
import com.smartdevicelink.proxy.rpc.ChangeRegistrationResponse;
import com.smartdevicelink.proxy.rpc.Choice;
import com.smartdevicelink.proxy.rpc.CreateInteractionChoiceSet;
import com.smartdevicelink.proxy.rpc.CreateInteractionChoiceSetResponse;
import com.smartdevicelink.proxy.rpc.DeleteCommandResponse;
import com.smartdevicelink.proxy.rpc.DeleteFileResponse;
import com.smartdevicelink.proxy.rpc.DeleteInteractionChoiceSetResponse;
import com.smartdevicelink.proxy.rpc.DeleteSubMenuResponse;
import com.smartdevicelink.proxy.rpc.DiagnosticMessageResponse;
import com.smartdevicelink.proxy.rpc.DialNumberResponse;
import com.smartdevicelink.proxy.rpc.EndAudioPassThruResponse;
import com.smartdevicelink.proxy.rpc.GenericResponse;
import com.smartdevicelink.proxy.rpc.GetDTCsResponse;
import com.smartdevicelink.proxy.rpc.GetInteriorVehicleDataResponse;
import com.smartdevicelink.proxy.rpc.GetSystemCapabilityResponse;
import com.smartdevicelink.proxy.rpc.GetVehicleDataResponse;
import com.smartdevicelink.proxy.rpc.GetWayPointsResponse;
import com.smartdevicelink.proxy.rpc.Image;
import com.smartdevicelink.proxy.rpc.ListFiles;
import com.smartdevicelink.proxy.rpc.ListFilesResponse;
import com.smartdevicelink.proxy.rpc.MenuParams;
import com.smartdevicelink.proxy.rpc.OnAudioPassThru;
import com.smartdevicelink.proxy.rpc.OnButtonEvent;
import com.smartdevicelink.proxy.rpc.OnButtonPress;
import com.smartdevicelink.proxy.rpc.OnCommand;
import com.smartdevicelink.proxy.rpc.OnDriverDistraction;
import com.smartdevicelink.proxy.rpc.OnHMIStatus;
import com.smartdevicelink.proxy.rpc.OnHashChange;
import com.smartdevicelink.proxy.rpc.OnInteriorVehicleData;
import com.smartdevicelink.proxy.rpc.OnKeyboardInput;
import com.smartdevicelink.proxy.rpc.OnLanguageChange;
import com.smartdevicelink.proxy.rpc.OnLockScreenStatus;
import com.smartdevicelink.proxy.rpc.OnPermissionsChange;
import com.smartdevicelink.proxy.rpc.OnStreamRPC;
import com.smartdevicelink.proxy.rpc.OnSystemRequest;
import com.smartdevicelink.proxy.rpc.OnTBTClientState;
import com.smartdevicelink.proxy.rpc.OnTouchEvent;
import com.smartdevicelink.proxy.rpc.OnVehicleData;
import com.smartdevicelink.proxy.rpc.OnWayPointChange;
import com.smartdevicelink.proxy.rpc.PerformAudioPassThruResponse;
import com.smartdevicelink.proxy.rpc.PerformInteraction;
import com.smartdevicelink.proxy.rpc.PerformInteractionResponse;
import com.smartdevicelink.proxy.rpc.PutFile;
import com.smartdevicelink.proxy.rpc.PutFileResponse;
import com.smartdevicelink.proxy.rpc.ReadDIDResponse;
import com.smartdevicelink.proxy.rpc.ResetGlobalPropertiesResponse;
import com.smartdevicelink.proxy.rpc.ScrollableMessageResponse;
import com.smartdevicelink.proxy.rpc.SendHapticDataResponse;
import com.smartdevicelink.proxy.rpc.SendLocation;
import com.smartdevicelink.proxy.rpc.SendLocationResponse;
import com.smartdevicelink.proxy.rpc.SetAppIconResponse;
import com.smartdevicelink.proxy.rpc.SetDisplayLayoutResponse;
import com.smartdevicelink.proxy.rpc.SetGlobalPropertiesResponse;
import com.smartdevicelink.proxy.rpc.SetInteriorVehicleDataResponse;
import com.smartdevicelink.proxy.rpc.SetMediaClockTimerResponse;
import com.smartdevicelink.proxy.rpc.Show;
import com.smartdevicelink.proxy.rpc.ShowConstantTbtResponse;
import com.smartdevicelink.proxy.rpc.ShowResponse;
import com.smartdevicelink.proxy.rpc.SliderResponse;
import com.smartdevicelink.proxy.rpc.SoftButton;
import com.smartdevicelink.proxy.rpc.SpeakResponse;
import com.smartdevicelink.proxy.rpc.StreamRPCResponse;
import com.smartdevicelink.proxy.rpc.SubscribeButtonResponse;
import com.smartdevicelink.proxy.rpc.SubscribeVehicleData;
import com.smartdevicelink.proxy.rpc.SubscribeVehicleDataResponse;
import com.smartdevicelink.proxy.rpc.SubscribeWayPointsResponse;
import com.smartdevicelink.proxy.rpc.SystemRequestResponse;
import com.smartdevicelink.proxy.rpc.TTSChunk;
import com.smartdevicelink.proxy.rpc.UnsubscribeButtonResponse;
import com.smartdevicelink.proxy.rpc.UnsubscribeVehicleData;
import com.smartdevicelink.proxy.rpc.UnsubscribeVehicleDataResponse;
import com.smartdevicelink.proxy.rpc.UnsubscribeWayPointsResponse;
import com.smartdevicelink.proxy.rpc.UpdateTurnListResponse;
import com.smartdevicelink.proxy.rpc.VrHelpItem;
import com.smartdevicelink.proxy.rpc.enums.FileType;
import com.smartdevicelink.proxy.rpc.enums.HMILevel;
import com.smartdevicelink.proxy.rpc.enums.ImageType;
import com.smartdevicelink.proxy.rpc.enums.InteractionMode;
import com.smartdevicelink.proxy.rpc.enums.LayoutMode;
import com.smartdevicelink.proxy.rpc.enums.LockScreenStatus;
import com.smartdevicelink.proxy.rpc.enums.RequestType;
import com.smartdevicelink.proxy.rpc.enums.SdlDisconnectedReason;
import com.smartdevicelink.proxy.rpc.enums.SoftButtonType;
import com.smartdevicelink.proxy.rpc.enums.SpeechCapabilities;
import com.smartdevicelink.proxy.rpc.enums.TextAlignment;
import com.smartdevicelink.proxy.rpc.listeners.OnRPCResponseListener;
import com.smartdevicelink.transport.BTTransportConfig;
import com.smartdevicelink.transport.BaseTransportConfig;
import com.smartdevicelink.transport.MultiplexTransportConfig;
import com.smartdevicelink.transport.TCPTransportConfig;
import com.smartdevicelink.transport.TransportConstants;
import com.smartdevicelink.transport.USBTransportConfig;
import com.smartdevicelink.util.CorrelationIdGenerator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class SdlService extends Service implements IProxyListenerALM{

	private static final String TAG 					= "SDL Service";

	private static final String APP_NAME 				= "Fleet Management";
	private static final String APP_ID 					= "614776325";

	private static final String ICON_FILENAME 			= "brasao_two.PNG";
	private static final String SDL_IMAGE_FILENAME  	= "sdl_full_image.png";
    private static final String BANCO_IMAGE1  	        = "brasao_two.PNG";
    private static final String BUSCAR_IMAGE            = "app_icon_one.png";
	private static final String BUSCAR_IMAGE2            = "disconnected.png";
	private static final String CAMPUS_IMAGE1           = "logo_cpar.png";

    private int iconCorrelationId;
    private int imageCorrelationId;
    private int CreateChoiceID;
    private int choiceSetID;
    private int performCorID;
    private Vector<SoftButton> softButtonsVector;

    /**
     * APP LOGIC
     */

    Vector<String> distances = new Vector<String>();
    public List<String> address = new ArrayList<String>();
    private List<String> remoteFiles;

    /*********************************************************************************************/
	
	private static final String WELCOME_SHOW 			= "Welcome to HelloSDL";
	private static final String WELCOME_SPEAK 			= "Welcome to Hello S D L";

    private static final String WELCOME_SHOW_BANCO      = "Bem-vindo ao Banco 24 Horas";
    private static final String BUSCAR_TEXT1             = "Pressione \"Buscar\" para";
    private static final String BUSCAR_TEXT2             = "encontrar o caixa mais próximo.";
    private static final String BUSCAR_TEXT3             = "mais próximo.";

    private static final String WELCOME_SPEAK_BANCO     = "Bem-vindo a ou, Banco 24 Horas, selecione a opção, buscar, para encontrar o caixa eletrônico mais próximo de você.";
	
	private static final String TEST_COMMAND_NAME 		= "Test Command";
    private static final String TEST_COMMAND_NAME1      = "Buscar";

    private static final int TEST_BUTTON_ID1            = 1000;
	private static final int TEST_BUTTON_ID2            = 2000;
	private static final int TEST_BUTTON_ID3            = 3000;
	private static final int TEST_COMMAND_ID 			= 1347;
    private static final int TEST_COMMAND_ID1           = 1;
    private String choice;
    private String rpm;
	private String speed;
	private static final int FOREGROUND_SERVICE_ID = 111;

	// TCP/IP transport config
	// The default port is 12345
	// The IP is of the machine that is running SDL Core
	private static final int TCP_PORT = 12345;
	private static final String DEV_MACHINE_IP_ADDRESS = "192.168.1.78";



	// variable to create and call functions of the SyncProxy
	private SdlProxyALM proxy = null;

	private boolean firstNonHmiNone = true;
	@SuppressWarnings("unused")
	private boolean isVehicleDataSubscribed = false;

	private String lockScreenUrlFromCore = null;
	private final LockScreenManager lockScreenManager = new LockScreenManager();

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
        Log.d(TAG, "onCreate");
		super.onCreate();
		remoteFiles = new ArrayList<>();

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			enterForeground();
		}
	}

	@SuppressLint("NewApi")
	public void enterForeground() {
		Notification notification = new Notification.Builder(this)
				.setContentTitle(getString(R.string.app_name))
				.setContentText("Connected through SDL")
				.setSmallIcon(R.drawable.ic_sdl)
				.setPriority(Notification.PRIORITY_DEFAULT)
				.build();
		startForeground(FOREGROUND_SERVICE_ID, notification);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		//Check if this was started with a flag to force a transport connect
		boolean forced = intent !=null && intent.getBooleanExtra(TransportConstants.FORCE_TRANSPORT_CONNECTED, false);
        startProxy(forced, intent);

		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		disposeSyncProxy();
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			stopForeground(true);
		}
		super.onDestroy();
	}

	private void startProxy(boolean forceConnect, Intent intent) {
        Log.i(TAG, "Trying to start proxy");
		if (proxy == null) {
			try {
                Log.i(TAG, "Starting SDL Proxy");
				BaseTransportConfig transport = null;
				if(BuildConfig.TRANSPORT.equals("MBT")){
					int securityLevel;
					if(BuildConfig.SECURITY.equals("HIGH")){
						securityLevel = MultiplexTransportConfig.FLAG_MULTI_SECURITY_HIGH;
					}else if(BuildConfig.SECURITY.equals("MED")){
						securityLevel = MultiplexTransportConfig.FLAG_MULTI_SECURITY_MED;
					}else if(BuildConfig.SECURITY.equals("LOW")){
						securityLevel = MultiplexTransportConfig.FLAG_MULTI_SECURITY_LOW;
					}else{
						securityLevel = MultiplexTransportConfig.FLAG_MULTI_SECURITY_OFF;
					}
					transport = new MultiplexTransportConfig(this, APP_ID, securityLevel);
				}else if(BuildConfig.TRANSPORT.equals("LBT")){
					transport = new BTTransportConfig();
				}else if(BuildConfig.TRANSPORT.equals("TCP")){
					transport = new TCPTransportConfig(TCP_PORT, DEV_MACHINE_IP_ADDRESS, true);
				}else if(BuildConfig.TRANSPORT.equals("USB")) {
					if (intent != null && intent.hasExtra(UsbManager.EXTRA_ACCESSORY)) { //If we want to support USB transport
						if (android.os.Build.VERSION.SDK_INT <= android.os.Build.VERSION_CODES.HONEYCOMB) {
							Log.e(TAG, "Unable to start proxy. Android OS version is too low");
							return;
						}else {
							//We have a usb transport
							transport = new USBTransportConfig(getBaseContext(), (UsbAccessory) intent.getParcelableExtra(UsbManager.EXTRA_ACCESSORY));
							Log.d(TAG, "USB created.");
						}
					}
				}
				if(transport != null) {
				    //For MANTICORE connection, comment:
					proxy = new SdlProxyALM(this, APP_NAME, false, APP_ID, transport);

					//For MANTICORE connection, uncomment:
                    //proxy = new SdlProxyALM(this, "Hello Sdl", false, "8675309", new TCPTransportConfig(5728, "m.sdl.tools", false));
				}
			} catch (SdlException e) {
				e.printStackTrace();
				// error creating proxy, returned proxy = null
				if (proxy == null) {
					stopSelf();
				}
			}
		}else if(forceConnect){
			proxy.forceOnConnected();
		}
	}

	private void disposeSyncProxy() {
		LockScreenActivity.updateLockScreenStatus(LockScreenStatus.OFF);

		if (proxy != null) {
			try {
				proxy.dispose();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				proxy = null;
			}
		}
		this.firstNonHmiNone = true;
		this.isVehicleDataSubscribed = false;
		
	}

	/**
	 * Will show a sample test message on screen as well as speak a sample test message
	 */
	private void showTest(){
		try {
			proxy.show(TEST_COMMAND_NAME, "Command has been selected", TextAlignment.CENTERED, CorrelationIdGenerator.generateId());
			proxy.speak(TEST_COMMAND_NAME, CorrelationIdGenerator.generateId());
		} catch (SdlException e) {
			e.printStackTrace();
		}
	}

	private void sampleAlert(){
        int corrId = CorrelationIdGenerator.generateId();

        Alert alert = new Alert();
        alert.setCorrelationID(corrId);
        alert.setAlertText1("Update your app!");
        alert.setAlertText2("General -> Apps -> Update");
        alert.setPlayTone(true);

        Vector<TTSChunk> chunksinit = new Vector<TTSChunk>();
        TTSChunk chunkI = new TTSChunk();
        chunkI.setText("Frase à ser dita pelo Sync");
        chunkI.setType(SpeechCapabilities.TEXT);
        chunksinit.add(chunkI);

        alert.setTtsChunks(chunksinit);

        //Botões do Alert
        SoftButton newSB2 = new SoftButton();
        newSB2.setSoftButtonID(545);
        newSB2.setType(SoftButtonType.SBT_TEXT);
        newSB2.setText("Ok");

        Vector<SoftButton> softButtons = new Vector<SoftButton>();
        softButtons.add(newSB2);

        alert.setSoftButtons(softButtons);

        try {
            proxy.sendRPCRequest(alert);
        } catch (SdlException e) {
            e.printStackTrace();
        }
    }

	private void performMainShow(){
		//Set the welcome message on screen
		Show newShow = new Show();
		newShow.setCorrelationID(CorrelationIdGenerator.generateId());

		Image newImage = new Image();
		newImage.setValue(CAMPUS_IMAGE1);
		newImage.setImageType(ImageType.DYNAMIC);
		newShow.setGraphic(newImage);

		newShow.setMainField1("Collect data of your vehicle");
        newShow.setMainField2("Click on \"Sub On\" to get ");
        newShow.setMainField3("real-time data");

		SoftButton newSB2 = new SoftButton();
		newSB2.setSoftButtonID(TEST_BUTTON_ID2);
		newSB2.setType(SoftButtonType.SBT_TEXT);
		newSB2.setText("Sub ON");

		Vector<SoftButton> softButtons = new Vector<SoftButton>();
		softButtons.add(newSB2);
		newShow.setSoftButtons(softButtons);

		try {
            proxy.setdisplaylayout("TEXT_AND_SOFTBUTTONS_WITH_GRAPHIC", CorrelationIdGenerator.generateId());
			proxy.sendRPCRequest(newShow);
		} catch (SdlException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Data show on Sync display.
	 */
	private void performDataViewShow(){
		Log.i("SAIDA", "ENTROU NO PDV");
		Show newShow2 = new Show();
		newShow2.setCorrelationID(CorrelationIdGenerator.generateId());

		newShow2.setMainField1("Speed: " + speed + " km/h");
		newShow2.setMainField2("RPM: " + rpm);
        newShow2.setMainField3("");

		SoftButton newSB1 = new SoftButton();
		newSB1.setSoftButtonID(TEST_BUTTON_ID3);
		newSB1.setType(SoftButtonType.SBT_TEXT);
		newSB1.setIsHighlighted(true);
		newSB1.setText("Sub OFF");

		Vector<SoftButton> softButtons = new Vector<SoftButton>();
		softButtons.add(newSB1);
		newShow2.setSoftButtons(softButtons);

		try {
			proxy.sendRPCRequest(newShow2);
		} catch (SdlException e) {
			e.printStackTrace();
		}
	}


	/**
	 *  Add commands for the app on SDL.
	 */
	private void sendCommands(){
		AddCommand command = new AddCommand();
		MenuParams params = new MenuParams();
		params.setMenuName(TEST_COMMAND_NAME1);
		command.setCmdID(TEST_COMMAND_ID1);
		command.setMenuParams(params);
		command.setVrCommands(Collections.singletonList(TEST_COMMAND_NAME1));
		sendRpcRequest(command);
	}

	/**
	 * Sends an RPC Request to the connected head unit. Automatically adds a correlation id.
	 * @param request the rpc request that is to be sent to the module
	 */
	private void sendRpcRequest(RPCRequest request){
		try {
			proxy.sendRPCRequest(request);
		} catch (SdlException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Sends the app icon through the uploadImage method with correct params
	 */
	private void sendIcon(){
		iconCorrelationId = CorrelationIdGenerator.generateId();
		uploadImage(R.mipmap.brasao_two, ICON_FILENAME, iconCorrelationId, true);
	}
	private void sendImagesToSync(){
        uploadImage(R.mipmap.logo_cpar, CAMPUS_IMAGE1, CorrelationIdGenerator.generateId(), true);
    }
	
	/**
	 * This method will help upload an image to the head unit
	 * @param resource the R.drawable.__ value of the image you wish to send
	 * @param imageName the filename that will be used to reference this image
	 * @param correlationId the correlation id to be used with this request. Helpful for monitoring putfileresponses
	 * @param isPersistent tell the system if the file should stay or be cleared out after connection.
	 */
	@SuppressWarnings("SameParameterValue")
	private void uploadImage(int resource, String imageName, int correlationId, boolean isPersistent){
		PutFile putFile = new PutFile();
		putFile.setFileType(FileType.GRAPHIC_PNG);
		putFile.setSdlFileName(imageName);
		putFile.setCorrelationID(correlationId);
		putFile.setPersistentFile(isPersistent);
		putFile.setSystemFile(false);
		putFile.setBulkData(contentsOfResource(resource));

		try {
			proxy.sendRPCRequest(putFile);
		} catch (SdlException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Helper method to take resource files and turn them into byte arrays
	 * @param resource Resource file id.
	 * @return Resulting byte array.
	 */
	private byte[] contentsOfResource(int resource) {
		InputStream is = null;
		try {
			is = getResources().openRawResource(resource);
			ByteArrayOutputStream os = new ByteArrayOutputStream(is.available());
			final int bufferSize = 4096;
			final byte[] buffer = new byte[bufferSize];
			int available;
			while ((available = is.read(buffer)) >= 0) {
				os.write(buffer, 0, available);
			}
			return os.toByteArray();
		} catch (IOException e) {
			Log.w(TAG, "Can't read icon file", e);
			return null;
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void onProxyClosed(String info, Exception e, SdlDisconnectedReason reason) {
		stopSelf();
		if(reason.equals(SdlDisconnectedReason.LANGUAGE_CHANGE) && BuildConfig.TRANSPORT.equals("MBT")){
			Intent intent = new Intent(TransportConstants.START_ROUTER_SERVICE_ACTION);
			intent.putExtra(SdlReceiver.RECONNECT_LANG_CHANGE, true);
			sendBroadcast(intent);
		}
	}

	@Override
	public void onOnHMIStatus(OnHMIStatus notification) {
        if(notification.getHmiLevel().equals(HMILevel.HMI_FULL)){
			if (notification.getFirstRun()) {
				// send welcome message if applicable

                sampleAlert();
                performMainShow();

                //performWelcomeMessage();

                // GetAllVehicleData
                getAllVehicleData();
			}
			// Other HMI (Show, PerformInteraction, etc.) would go here
		}

		if(!notification.getHmiLevel().equals(HMILevel.HMI_NONE)
				&& firstNonHmiNone){
            //subscribeEcallInfo();
			sendCommands();
			//uploadImages();
			firstNonHmiNone = false;
			
			// Other app setup (SubMenu, CreateChoiceSet, etc.) would go here
		}else{
			//We have HMI_NONE
			if(notification.getFirstRun()){
			    //subscribeEcallInfo();
				uploadImages();
			}
		}
	}

	/**
	 * Listener for handling when a lockscreen image is downloaded.
	 */
	private class LockScreenDownloadedListener implements LockScreenManager.OnLockScreenIconDownloadedListener{

		@Override
		public void onLockScreenIconDownloaded(Bitmap icon) {
			Log.i(TAG, "Lock screen icon downloaded successfully");
			LockScreenActivity.updateLockScreenImage(icon);
		}

		@Override
		public void onLockScreenIconDownloadError(Exception e) {
			Log.e(TAG, "Couldn't download lock screen icon, resorting to default.");
			LockScreenActivity.updateLockScreenImage(BitmapFactory.decodeResource(getResources(),
					R.drawable.sdl));
		}
	}
	
	/**
	 * Will show a sample welcome message on screen as well as speak a sample welcome message
	 */
	private void performWelcomeMessage(){
		try {
			Image image = new Image();
			image.setValue(CAMPUS_IMAGE1);
			image.setImageType(ImageType.DYNAMIC);

            SoftButton newSB = new SoftButton();
            newSB.setSoftButtonID(TEST_BUTTON_ID1);
            newSB.setType(SoftButtonType.SBT_BOTH);
            newSB.setText(TEST_COMMAND_NAME1);

            Log.i("SAÍDA","Início da definição da imagem para softButton");
            //Image IM = new Image();
            //IM.setValue(BUSCAR_IMAGE);
            //IM.setImageType(ImageType.DYNAMIC);
            //newSB.setImage(IM);

            softButtonsVector = new Vector<SoftButton>();
            softButtonsVector.add(newSB);

			//Set the welcome message on screen
            proxy.setdisplaylayout("TEXT_AND_SOFTBUTTONS_WITH_GRAPHIC", CorrelationIdGenerator.generateId());
			proxy.show(BUSCAR_TEXT1, BUSCAR_TEXT2, null, null, null, null, null, image, softButtonsVector, null, TextAlignment.CENTERED, CorrelationIdGenerator.generateId());
			
			//Say the welcome message
			proxy.speak(WELCOME_SPEAK_BANCO, CorrelationIdGenerator.generateId());
			
		} catch (SdlException e) {
			e.printStackTrace();
		}
		
	}

    /**
     * Set Distances
     */
    public void setDistances() {
        distances.add("100");
        distances.add("270");
        distances.add("310");
        distances.add("420");
        distances.add("480");
        distances.add("760");
    }

    /**
     * Set Address for Send Location method
     */
    public void setAddress(ArrayList<String> addressLines){
        address.addAll(addressLines);
    }

    /**
     * Create Choice set of Banco24Horas
     */
    public void sampleCreateChoiceSet(){
        CreateChoiceID = CorrelationIdGenerator.generateId();
        setDistances();
        Vector<Choice> commands = new Vector<Choice>();

        // ------------------------------- OPÇÃO 1 -----------------------------------
        Choice one = new Choice();
        one.setChoiceID(100);
        one.setMenuName("1. " + distances.get(0) + " metros");
        Vector<String> vrCommands = new Vector<String>();
        //vrCommands.add("cem");
        vrCommands.add(distances.get(0));
        vrCommands.add(distances.get(0) + " métros");
        vrCommands.add("Opção 1");
        vrCommands.add("Um");
        one.setVrCommands(vrCommands);

        commands.add(one);
        // ------------------------------- OPÇÃO 2 -----------------------------------
        Choice two = new Choice();
        two.setChoiceID(200);
        two.setMenuName("2. " + distances.get(1) + " metros");
        Vector<String> vrCommands2 = new Vector<String>();
        vrCommands2.add(distances.get(1));
        vrCommands2.add(distances.get(1) + " métros");
        vrCommands2.add("Opção 2");
        vrCommands2.add("Dois");
        two.setVrCommands(vrCommands2);

        commands.add(two);

        // ------------------------------- OPÇÃO 3 -----------------------------------
        Choice three = new Choice();
        three.setChoiceID(300);
        three.setMenuName("3. " + distances.get(2) + " metros");
        Vector<String> vrCommands3 = new Vector<String>();
        vrCommands3.add(distances.get(2));
        vrCommands3.add(distances.get(2) + " métros");
        vrCommands3.add("Opção 3");
        vrCommands3.add("Três");
        three.setVrCommands(vrCommands3);

        commands.add(three);

        // ------------------------------- OPÇÃO 4 -----------------------------------
        Choice four = new Choice();
        four.setChoiceID(400);
        four.setMenuName("4. " + distances.get(3) + " metros");
        Vector<String> vrCommands4 = new Vector<String>();
        vrCommands4.add(distances.get(3));
        vrCommands4.add(distances.get(3) + " métros");
        vrCommands4.add("Opção 4");
        vrCommands4.add("Quatro");
        four.setVrCommands(vrCommands4);

        commands.add(four);

        // ------------------------------- OPÇÃO 5 -----------------------------------
        Choice five = new Choice();
        five.setChoiceID(500);
        five.setMenuName("5. " + distances.get(4) + " metros");
        Vector<String> vrCommands5 = new Vector<String>();
        vrCommands5.add(distances.get(4));
        vrCommands5.add(distances.get(4) + " métros");
        vrCommands5.add("Opção 5");
        vrCommands5.add("Cinco");
        five.setVrCommands(vrCommands5);

        commands.add(five);

        Image image = new Image();
        image.setValue(BANCO_IMAGE1);
        image.setImageType(ImageType.DYNAMIC);
        one.setImage(image);
        two.setImage(image);
        three.setImage(image);
        four.setImage(image);
        five.setImage(image);

        //Build Request and send to proxy object:
        CreateInteractionChoiceSet msg = new CreateInteractionChoiceSet();
        msg.setCorrelationID(CreateChoiceID);
        choiceSetID = CorrelationIdGenerator.generateId();
        msg.setInteractionChoiceSetID(choiceSetID);
        msg.setChoiceSet(commands);

        try {
            proxy.sendRPCRequest(msg);
        } catch (
                SdlException e) {
            Log.i(TAG,"sync exception Choice");
            e.printStackTrace();
        }
    }

    public void samplePerformInteraction(String choice)
    {
        /******Prerequisite CreateInteractionChoiceSet Occurs Prior to PerformInteraction*******/
        //Build Request and send to proxy object:
        performCorID = CreateChoiceID;
        PerformInteraction msg = new PerformInteraction();
        msg.setCorrelationID(performCorID);
        msg.setInitialText("Escolha um caixa eletrônico: ");

        Vector<TTSChunk> chunksinit = new Vector<TTSChunk>();
        TTSChunk chunkI = new TTSChunk();
        chunkI.setText("Escolha um caixa eletrônico");
        chunkI.setType(SpeechCapabilities.TEXT);
        chunksinit.add(chunkI);

        msg.setInitialPrompt(chunksinit);

        if(choice == "VR_ONLY") {
            msg.setInteractionMode(InteractionMode.VR_ONLY);

        }else if(choice == "MANUAL_ONLY"){
            msg.setInteractionMode(InteractionMode.MANUAL_ONLY);
        }

        Vector<Integer> choiceSetIDs = new Vector<Integer>();
        choiceSetIDs.add(choiceSetID);// match the ID used in CreateInteractionChoiceSet
        msg.setInteractionChoiceSetIDList(choiceSetIDs);


        Vector<TTSChunk> chunksAjuda = new Vector<TTSChunk>();
        TTSChunk chunkA = new TTSChunk();
        chunkA.setText(distances.get(0) + " metros , " + distances.get(1) + " metros" + distances.get(2) + " metros"
                + distances.get(3) + " metros" + distances.get(4) + " metros");
        chunkA.setType(SpeechCapabilities.TEXT);
        chunksAjuda.add(chunkA);

        Vector<TTSChunk> chunksTimeout = new Vector<TTSChunk>();
        TTSChunk chunkT = new TTSChunk();
        chunkT.setText(distances.get(0) + " metros , " + distances.get(1) + " metros" + distances.get(2) + " metros"
                + distances.get(3) + " metros" + distances.get(4) + " metros");
        chunkT.setType(SpeechCapabilities.TEXT);
        chunksTimeout.add(chunkT);

        msg.setHelpPrompt(chunksAjuda);
        msg.setTimeoutPrompt(chunksTimeout);
        msg.setInteractionLayout(LayoutMode.LIST_ONLY);
        //msg.setTimeout(10000); //min value 5000, max 10000 milliseconds

        if(choice=="MANUAL_ONLY") {
            Vector<VrHelpItem> vrHelpItems = new Vector<VrHelpItem>();
            VrHelpItem item1 = new VrHelpItem();
            item1.setText(distances.get(0) + " metros");
            item1.setPosition(1);

            VrHelpItem item2 = new VrHelpItem();
            item2.setText(distances.get(1) + " metros");
            item2.setPosition(2);

            VrHelpItem item3 = new VrHelpItem();
            item3.setText(distances.get(2) + " metros");
            item3.setPosition(3);

            VrHelpItem item4 = new VrHelpItem();
            item4.setText(distances.get(3) + " metros");
            item4.setPosition(4);

            VrHelpItem item5 = new VrHelpItem();
            item5.setText(distances.get(4) + " metros");
            item5.setPosition(5);

            vrHelpItems.add(item1);
            vrHelpItems.add(item2);
            vrHelpItems.add(item3);
            vrHelpItems.add(item4);
            vrHelpItems.add(item5);
            msg.setVrHelp(vrHelpItems);

        }else {

            Vector<VrHelpItem> vrHelpItems = new Vector<VrHelpItem>();
            VrHelpItem item1 = new VrHelpItem();
            item1.setText("1. " +  distances.get(0) + " metros");
            item1.setPosition(1);

            VrHelpItem item2 = new VrHelpItem();
            item2.setText("2. " +  distances.get(1) + " metros");
            item2.setPosition(2);

            VrHelpItem item3 = new VrHelpItem();
            item3.setText("3. " +  distances.get(2) + " metros");
            item3.setPosition(3);

            VrHelpItem item4 = new VrHelpItem();
            item4.setText("4. " +  distances.get(3) + " metros");
            item4.setPosition(4);

            VrHelpItem item5 = new VrHelpItem();
            item5.setText("5. " +  distances.get(4) + " metros");
            item5.setPosition(5);

            vrHelpItems.add(item1);
            vrHelpItems.add(item2);
            vrHelpItems.add(item3);
            vrHelpItems.add(item4);
            vrHelpItems.add(item5);
            msg.setVrHelp(vrHelpItems);
        }

        try{
            proxy.sendRPCRequest(msg);
        } catch (SdlException e) {
            Log.i(TAG,"sync exception");
            e.printStackTrace();
        }
    }

	/**
	 *  Requests list of images to SDL, and uploads images that are missing.
	 */
	private void uploadImages(){
		ListFiles listFiles = new ListFiles();
		this.sendRpcRequest(listFiles);
	}

    public void sendlocationMethod(double Latitude, double Longitude, String LocationName, String PhoneNumber, ArrayList<String> AddressLines){

        SendLocation msgsendLoc = new SendLocation();
        msgsendLoc.setCorrelationID(CorrelationIdGenerator.generateId());
        msgsendLoc.setLatitudeDegrees(Latitude);
        msgsendLoc.setLongitudeDegrees(Longitude);
        msgsendLoc.setLocationName(LocationName);
        msgsendLoc.setPhoneNumber(PhoneNumber);
        msgsendLoc.setAddressLines(AddressLines);

        Image newImage = new Image();
        newImage.setValue(BANCO_IMAGE1);
        newImage.setImageType(ImageType.DYNAMIC);
        msgsendLoc.setLocationImage(newImage);

        try {
            proxy.sendRPCRequest(msgsendLoc);
        } catch (SdlException e) {
            e.printStackTrace();
        }
    }
    public void sampleSubscribeVehicleData(){
        SubscribeVehicleData vehicleData = new SubscribeVehicleData();
        vehicleData.setCorrelationID(CorrelationIdGenerator.generateId());

        vehicleData.setSpeed(true);
        vehicleData.setRpm(true);
        vehicleData.setFuelLevel(true);
        vehicleData.setOdometer(true);

        try {
            proxy.sendRPCRequest(vehicleData);
        } catch (SdlException e) {
            e.printStackTrace();
        }
    }

    public void sampleUnsubscribeVehicleData(){
        UnsubscribeVehicleData vehicleData = new UnsubscribeVehicleData();
        vehicleData.setCorrelationID(CorrelationIdGenerator.generateId());

        vehicleData.setSpeed(true);
        vehicleData.setRpm(true);
        vehicleData.setFuelLevel(true);
        vehicleData.setOdometer(true);

        try {
            proxy.sendRPCRequest(vehicleData);
        } catch (SdlException e) {
            e.printStackTrace();
        }

    }

	public void getAllVehicleData(){
		try {
			proxy.getvehicledata(true,true,true,true,true,
					true,true,true,true,
					true,true,true, true, true, true, CorrelationIdGenerator.generateId());
		}catch (SdlException e){
			e.printStackTrace();
		}
	}

    /**
     *  Listeners:
     */

	@Override
	public void onListFilesResponse(ListFilesResponse response) {
		Log.i(TAG, "onListFilesResponse from SDL ");
        if(response.getSuccess()){
            remoteFiles = response.getFilenames();
        }
		if(remoteFiles== null || !remoteFiles.contains(SdlService.ICON_FILENAME)
                              || !remoteFiles.contains(SdlService.CAMPUS_IMAGE1)){
		    try{
		        sendIcon();
		        sendImagesToSync();
            }catch (Exception e){
		        e.printStackTrace();
            }
        }else{
		    try {
		        proxy.setappicon(ICON_FILENAME, CorrelationIdGenerator.generateId());
            }catch (Exception e){
		        e.printStackTrace();
            }
        }
	}

	@Override
	public void onPutFileResponse(PutFileResponse response) {
		Log.i(TAG, "onPutFileResponse from SDL");
		if(response.getCorrelationID() == iconCorrelationId){ //If we have successfully uploaded our icon, we want to set it
			try {
				proxy.setappicon(ICON_FILENAME, CorrelationIdGenerator.generateId());
			} catch (SdlException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void onOnLockScreenNotification(OnLockScreenStatus notification) {
		//LockScreenActivity.updateLockScreenStatus(notification.getShowLockScreen());
	}

	@Override
	public void onOnCommand(OnCommand notification){
		Integer id = notification.getCmdID();
        choice = "VR_ONLY";
		if(id != null){
			switch(id){
				case TEST_COMMAND_ID:
					showTest();
					break;
                case TEST_COMMAND_ID1:
                    sampleCreateChoiceSet();
                    break;
			}
		}
	}

	/**
	 *  Callback method that runs when the add command response is received from SDL.
	 */
	@Override
	public void onAddCommandResponse(AddCommandResponse response) {
		Log.i(TAG, "AddCommand response from SDL: " + response.getResultCode().name());

	}

	/*  Vehicle Data   */
	@Override
	public void onOnPermissionsChange(OnPermissionsChange notification) {
		Log.i(TAG, "Permision changed: " + notification);

		/* Uncomment to subscribe to vehicle data
		List<PermissionItem> permissions = notification.getPermissionItem();
		for(PermissionItem permission:permissions){
			if(permission.getRpcName().equalsIgnoreCase(FunctionID.SUBSCRIBE_VEHICLE_DATA.name())){
				if(permission.getHMIPermissions().getAllowed()!=null && permission.getHMIPermissions().getAllowed().size()>0){
					if(!isVehicleDataSubscribed){ //If we haven't already subscribed we will subscribe now
						//TODO: Add the vehicle data items you want to subscribe to
						//proxy.subscribevehicledata(gps, speed, rpm, fuelLevel, fuelLevel_State, instantFuelConsumption, externalTemperature, prndl, tirePressure, odometer, beltStatus, bodyInformation, deviceStatus, driverBraking, correlationID);
						proxy.subscribevehicledata(false, true, rpm, false, false, false, false, false, false, false, false, false, false, false, autoIncCorrId++);
					}
				}
			}
		}
		*/
	}

	/**
	 * Rest of the SDL callbacks from the head unit
	 */

	@Override
	public void onSubscribeVehicleDataResponse(SubscribeVehicleDataResponse response) {
        Log.i(TAG, "SubscribeVehicleData response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
		if(response.getSuccess()){
			Log.i(TAG, "Subscribed to vehicle data");
			this.isVehicleDataSubscribed = true;
		}
	}
	
	@Override
	public void onOnVehicleData(OnVehicleData notification) {
		Log.i("SAÍDA", "Vehicle data notification from SDL");
		//TODO Put your vehicle data code here
		try {
            if(notification.getRpm() != null){
            	rpm = notification.getRpm().toString();
			}
			if(notification.getSpeed() != null){
            	speed = notification.getSpeed().toString();
			}
        }catch (Exception e){
		    e.printStackTrace();

        }
	}
	
	@Override
	public void onAddSubMenuResponse(AddSubMenuResponse response) {
        Log.i(TAG, "AddSubMenu response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onCreateInteractionChoiceSetResponse(CreateInteractionChoiceSetResponse response) {
        Log.i(TAG, "CreateInteractionChoiceSet response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
        String Result = response.getResultCode().toString();
        if(response.getSuccess() && response.getCorrelationID() == CreateChoiceID) {
            if (choice == "VR_ONLY") {
                samplePerformInteraction("VR_ONLY");
            } else if (choice == "MANUAL_ONLY") {
                samplePerformInteraction("MANUAL_ONLY");
            }
        }
	}

	@Override
	public void onAlertResponse(AlertResponse response) {
        Log.i(TAG, "Alert response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onDeleteCommandResponse(DeleteCommandResponse response) {
        Log.i(TAG, "DeleteCommand response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onDeleteInteractionChoiceSetResponse(DeleteInteractionChoiceSetResponse response) {
        Log.i(TAG, "DeleteInteractionChoiceSet response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onDeleteSubMenuResponse(DeleteSubMenuResponse response) {
        Log.i(TAG, "DeleteSubMenu response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onPerformInteractionResponse(PerformInteractionResponse response) {
        Log.i(TAG, "PerformInteraction response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
        if(response.getSuccess()) {
            ArrayList<String> addressVector = new ArrayList<String>();
            if (response.getCorrelationID() == performCorID) {
                switch (response.getChoiceID()) {
                    case 100:
                        addressVector.add("Av. Taboão, 899");
                        addressVector.add("São Bernardo do Campo");
                        addressVector.add("SP");
                        setAddress(addressVector);
                        sendlocationMethod(-23.653437, -46.591862, "Banco24Horas - Ford", "0800562400", (ArrayList<String>) address);
                        break;

                    case 200:
                        addressVector.add("Av. do Taboão, 2000");
                        addressVector.add("São Bernardo do Campo");
                        addressVector.add("SP");
                        setAddress(addressVector);
                        sendlocationMethod(-23.6553053, -46.5953038, "Banco24Horas - Carrefour", "0800562400", (ArrayList<String>) address);
                        break;

                    case 300:
                        addressVector.add("Av. Caminho do Mar, 3629");
                        addressVector.add("São Bernardo do Campo");
                        addressVector.add("SP");
                        setAddress(addressVector);
                        sendlocationMethod(-23.6546088, -46.575156, "Banco24Horas - Extra", "0800562400", (ArrayList<String>) address);
                        break;
                    case 400:
                        addressVector.add("Av. Caminho do Mar, 3344");
                        addressVector.add("São Bernardo do Campo");
                        addressVector.add("SP");
                        setAddress(addressVector);
                        sendlocationMethod(-23.6576255, -46.591862, "Banco24Horas - Mercado Municipal", "0800562400", (ArrayList<String>) address);
                        break;
                    case 500:
                        addressVector.add("Av. Doutor Rudge Ramos, 500");
                        addressVector.add("São Bernardo do Campo");
                        addressVector.add("SP");
                        setAddress(addressVector);
                        sendlocationMethod(-23.6513422, -46.5753004, "Banco24Horas - Coop", "0800562400", (ArrayList<String>) address);
                        break;
                    default:
                        return;
                }
                address.clear();
            }
        }
	}

	@Override
	public void onResetGlobalPropertiesResponse(
			ResetGlobalPropertiesResponse response) {
        Log.i(TAG, "ResetGlobalProperties response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onSetGlobalPropertiesResponse(SetGlobalPropertiesResponse response) {
        Log.i(TAG, "SetGlobalProperties response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onSetMediaClockTimerResponse(SetMediaClockTimerResponse response) {
        Log.i(TAG, "SetMediaClockTimer response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onShowResponse(ShowResponse response) {
        Log.i(TAG, "Show response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onSpeakResponse(SpeakResponse response) {
        Log.i(TAG, "SpeakCommand response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onOnButtonEvent(OnButtonEvent notification) {
        Log.i(TAG, "OnButtonEvent notification from SDL: " + notification);
	}

	@Override
	public void onOnButtonPress(OnButtonPress notification) {
        Log.i(TAG, "OnButtonPress notification from SDL: " + notification);
        choice = "MANUAL_ONLY";
        switch (notification.getButtonName()) {
            case CUSTOM_BUTTON:
                switch (notification.getCustomButtonName()) {
                    case TEST_BUTTON_ID1: // rss icon was pressed on main screen
                        Log.i(TAG, "Button \"BUSCAR\" was pressed");
                        sampleCreateChoiceSet();
                        break;
					case TEST_BUTTON_ID2:
						sampleSubscribeVehicleData();
						performDataViewShow();
						break;
					case TEST_BUTTON_ID3:
						sampleUnsubscribeVehicleData();
						performMainShow();
						break;
                }
        }
	}

	@Override
	public void onSubscribeButtonResponse(SubscribeButtonResponse response) {
        Log.i(TAG, "SubscribeButton response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onUnsubscribeButtonResponse(UnsubscribeButtonResponse response) {
        Log.i(TAG, "UnsubscribeButton response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onOnTBTClientState(OnTBTClientState notification) {
        Log.i(TAG, "OnTBTClientState notification from SDL: " + notification);
	}

	@Override
	public void onUnsubscribeVehicleDataResponse(
			UnsubscribeVehicleDataResponse response) {
        Log.i(TAG, "UnsubscribeVehicleData response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	VehicleDataInterface VehicleData = new VehicleDataInterface();

	@Override
	public void onGetVehicleDataResponse(GetVehicleDataResponse response) {
        Log.i(TAG, "GetVehicleData response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
		if(response.getSuccess()) {
			//getVehicleType();
			try {
				//VehicleData.setVin(response.getVin());
				VehicleData.setPRNDL(response.getPrndl().toString());
				VehicleData.setSpeed(response.getSpeed().toString());
				VehicleData.setRpm(response.getRpm().toString());
				VehicleData.setFuelLevel(response.getFuelLevel().toString());
				//VehicleData.setFuelLevel_State(response.getFuelLevel_State().toString());
				//VehicleData.setOdometer(response.getOdometer().toString());
				VehicleData.setExternalTemperature(response.getExternalTemperature().toString());
				VehicleData.setDriverBreaking(response.getDriverBraking().toString());
				VehicleData.setEngineTorque(String.valueOf(response.getEngineTorque()));
			} catch (Exception e) {
				e.printStackTrace();
			}

        /* GPS */
			try {
				VehicleData.setLatitudeDegrees(response.getGps().getLatitudeDegrees().toString());
				VehicleData.setLongitudeDegrees(response.getGps().getLongitudeDegrees().toString());
				VehicleData.setAltitude(response.getGps().getAltitude().toString());
				VehicleData.setHeading(response.getGps().getHeading().toString());
				VehicleData.setDirection(response.getGps().getCompassDirection().toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
        /* Head Lamps */
			try {
			    if(response.getHeadLampStatus().getLowBeamsOn().booleanValue()) VehicleData.setLowBeamsOn("true");
                else VehicleData.setLowBeamsOn("false");
                if(response.getHeadLampStatus().getHighBeamsOn().booleanValue()) VehicleData.setHighBeamsOn("true");
                else VehicleData.setHighBeamsOn("false");
				VehicleData.setAmbientLightStatus(response.getHeadLampStatus().getAmbientLightStatus().toString());
			} catch (Exception e) {
				e.printStackTrace();
			}

        /* Body Information */
			try {
				VehicleData.setDriverDoorAjar(response.getBodyInformation().getDriverDoorAjar().toString());
				VehicleData.setPassengerDoorAjar(response.getBodyInformation().getPassengerDoorAjar().toString());
				VehicleData.setRearRightDoorAjar(response.getBodyInformation().getRearRightDoorAjar().toString());
				VehicleData.setRearLeftDoorAjar(response.getBodyInformation().getRearLeftDoorAjar().toString());
				VehicleData.setIgnitionStatus(response.getBodyInformation().getIgnitionStatus().toString());
				VehicleData.setIgnitionStatusStable(response.getBodyInformation().getIgnitionStableStatus().toString());
				VehicleData.setParkBrakeActive(response.getBodyInformation().getParkBrakeActive().toString());
			} catch (Exception e) {
				e.printStackTrace();
			}

        /* Tire Pressures */
			try {
				VehicleData.setRightRearStatus(response.getTirePressure().getRightRear().getStatus().toString());
				VehicleData.setLeftRearStatus(response.getTirePressure().getLeftRear().getStatus().toString());
				VehicleData.setRightFrontStatus(response.getTirePressure().getRightFront().getStatus().toString());
				VehicleData.setLeftFrontStatus(response.getTirePressure().getLeftFront().getStatus().toString());
				VehicleData.setRightRearValue(response.getTirePressure().getInnerRightRear().getStatus().toString());
				VehicleData.setLeftRearValue(response.getTirePressure().getInnerLeftRear().getStatus().toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
			//Timer for send and get updated data (if we have a loop).
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//Send VehicleData to Vehicle_Info activity.
			VehicleDataToActivity();
			//Comment if you don't want a loop of getVehicleData
			getAllVehicleData();
		}
	}

	/**
	 * Sending VehicleData object by BroadcastMethod to Vehicle_Info activity.
	 */
	private void VehicleDataToActivity(){
		Intent intent = new Intent("VehicleDataSent");
		sendVehicleDataBroadcast(intent);
	}

	private void sendVehicleDataBroadcast(Intent intent){
		VehicleData.setName("Teste");
		intent.putExtra("VehicleData", VehicleData);
		LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
	}
	/*********************************************************************************************/

	@Override
	public void onReadDIDResponse(ReadDIDResponse response) {
        Log.i(TAG, "ReadDID response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onGetDTCsResponse(GetDTCsResponse response) {
        Log.i(TAG, "GetDTCs response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onPerformAudioPassThruResponse(PerformAudioPassThruResponse response) {
        Log.i(TAG, "PerformAudioPassThru response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onEndAudioPassThruResponse(EndAudioPassThruResponse response) {
        Log.i(TAG, "EndAudioPassThru response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onOnAudioPassThru(OnAudioPassThru notification) {
		Log.i(TAG, "OnAudioPassThru notification from SDL: " + notification );
	}

	@Override
	public void onDeleteFileResponse(DeleteFileResponse response) {
        Log.i(TAG, "DeleteFile response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onSetAppIconResponse(SetAppIconResponse response) {
        Log.i(TAG, "SetAppIcon response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onScrollableMessageResponse(ScrollableMessageResponse response) {
        Log.i(TAG, "ScrollableMessage response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onChangeRegistrationResponse(ChangeRegistrationResponse response) {
        Log.i(TAG, "ChangeRegistration response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onSetDisplayLayoutResponse(SetDisplayLayoutResponse response) {
        Log.i(TAG, "SetDisplayLayout response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onOnLanguageChange(OnLanguageChange notification) {
        Log.i(TAG, "OnLanguageChange notification from SDL: " + notification);
	}

	@Override
	public void onSliderResponse(SliderResponse response) {
        Log.i(TAG, "Slider response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onOnHashChange(OnHashChange notification) {
        Log.i(TAG, "OnHashChange notification from SDL: " + notification);
	}

	@Override
	public void onOnSystemRequest(OnSystemRequest notification) {
        Log.i(TAG, "OnSystemRequest notification from SDL: " + notification);

		// Download the lockscreen icon Core desires
		if(notification.getRequestType().equals(RequestType.LOCK_SCREEN_ICON_URL) && lockScreenUrlFromCore == null){
			lockScreenUrlFromCore = notification.getUrl();
			if(lockScreenUrlFromCore != null && lockScreenManager.getLockScreenIcon() == null){
				lockScreenManager.downloadLockScreenIcon(lockScreenUrlFromCore, new LockScreenDownloadedListener());
			}
		}
	}

	@Override
	public void onSystemRequestResponse(SystemRequestResponse response) {
        Log.i(TAG, "SystemRequest response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onOnKeyboardInput(OnKeyboardInput notification) {
        Log.i(TAG, "OnKeyboardInput notification from SDL: " + notification);
	}

	@Override
	public void onOnTouchEvent(OnTouchEvent notification) {
        Log.i(TAG, "OnTouchEvent notification from SDL: " + notification);
	}

	@Override
	public void onDiagnosticMessageResponse(DiagnosticMessageResponse response) {
        Log.i(TAG, "DiagnosticMessage response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onOnStreamRPC(OnStreamRPC notification) {
        Log.i(TAG, "OnStreamRPC notification from SDL: " + notification);
	}

	@Override
	public void onStreamRPCResponse(StreamRPCResponse response) {
        Log.i(TAG, "StreamRPC response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onDialNumberResponse(DialNumberResponse response) {
        Log.i(TAG, "DialNumber response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onSendLocationResponse(SendLocationResponse response) {
        Log.i(TAG, "SendLocation response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onServiceEnded(OnServiceEnded serviceEnded) {

	}

	@Override
	public void onServiceNACKed(OnServiceNACKed serviceNACKed) {

	}

	@Override
	public void onShowConstantTbtResponse(ShowConstantTbtResponse response) {
        Log.i(TAG, "ShowConstantTbt response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onAlertManeuverResponse(AlertManeuverResponse response) {
        Log.i(TAG, "AlertManeuver response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onUpdateTurnListResponse(UpdateTurnListResponse response) {
        Log.i(TAG, "UpdateTurnList response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onServiceDataACK(int dataSize) {

	}

	@Override
	public void onGetWayPointsResponse(GetWayPointsResponse response) {
		Log.i(TAG, "GetWayPoints response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onSubscribeWayPointsResponse(SubscribeWayPointsResponse response) {
		Log.i(TAG, "SubscribeWayPoints response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onUnsubscribeWayPointsResponse(UnsubscribeWayPointsResponse response) {
		Log.i(TAG, "UnsubscribeWayPoints response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onOnWayPointChange(OnWayPointChange notification) {
		Log.i(TAG, "OnWayPointChange notification from SDL: " + notification);
	}

	@Override
	public void onOnDriverDistraction(OnDriverDistraction notification) {
		// Some RPCs (depending on region) cannot be sent when driver distraction is active.
	}

	@Override
	public void onError(String info, Exception e) {
	}

	@Override
	public void onGenericResponse(GenericResponse response) {
        Log.i(TAG, "Generic response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onGetSystemCapabilityResponse(GetSystemCapabilityResponse response) {
		Log.i(TAG, "GetSystemCapabilityResponse from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onSendHapticDataResponse(SendHapticDataResponse response){
		Log.i(TAG, "SendHapticData response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onButtonPressResponse(ButtonPressResponse response) {
        Log.i(TAG, "ButtonPress response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
    }

	@Override
	public void onSetInteriorVehicleDataResponse(SetInteriorVehicleDataResponse response) {
		Log.i(TAG, "SetInteriorVehicleData response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onGetInteriorVehicleDataResponse(GetInteriorVehicleDataResponse response) {
		Log.i(TAG, "GetInteriorVehicleData response from SDL: " + response.getResultCode().name() + " Info: " + response.getInfo());
	}

	@Override
	public void onOnInteriorVehicleData(OnInteriorVehicleData notification) {
		Log.i(TAG, "OnInteriorVehicleData from SDL: " + notification);

	}

}
