package deepshooter.com.customlauncher.Widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RemoteViews;

import deepshooter.com.customlauncher.MainActivity;
import deepshooter.com.customlauncher.R;


/**
 * Created by parimalam.p on 7/7/2016.
 */
public class ExampleAppWidgetProvider extends AppWidgetProvider {

    private static final String ACTION_CLICK = "ACTION_CLICK";

    ImageView  video , music , search;

    // our actions for our buttons
    public static String ACTION_WIDGET_MUSIC = "ActionReceiverMusic";
    public static String ACTION_WIDGET_VIDEO = "ActionReceiverVideo";
    public static String ACTION_WIDGET_SEARCH = "ActionReceiverSearch";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {
        Log.e("WidgetExample", "Testing");
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_layout);

        Intent active = new Intent(context, ExampleAppWidgetProvider.class);
        active.setAction(ACTION_WIDGET_MUSIC);
        PendingIntent actionPendingIntent = PendingIntent.getBroadcast(context, 0, active, 0);
        remoteViews.setOnClickPendingIntent(R.id.music, actionPendingIntent);

        active = new Intent(context, ExampleAppWidgetProvider.class);
        active.setAction(ACTION_WIDGET_VIDEO);
        actionPendingIntent = PendingIntent.getBroadcast(context, 0, active, 0);
        remoteViews.setOnClickPendingIntent(R.id.video, actionPendingIntent);

        active = new Intent(context, ExampleAppWidgetProvider.class);
        active.setAction(ACTION_WIDGET_SEARCH);
        actionPendingIntent = PendingIntent.getBroadcast(context, 0, active, 0);
        remoteViews.setOnClickPendingIntent(R.id.chrome, actionPendingIntent);

        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);

        }

    @Override
    public void onReceive(Context context, Intent intent) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(
                context);
        ComponentName thisWidget = new ComponentName(context,
                ExampleAppWidgetProvider.class);

        onUpdate(context,appWidgetManager ,appWidgetManager.getAppWidgetIds(thisWidget));

        if (intent.getAction().equals(ACTION_WIDGET_MUSIC)) {
            Log.i("onReceive", ACTION_WIDGET_MUSIC);
            //Intent LaunchIntent = context.getPackageManager().getLaunchIntentForPackage("com.google.android.music");
            Intent LaunchIntent = new Intent(context, MainActivity.class);
            LaunchIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity( LaunchIntent );

        } else if (intent.getAction().equals(ACTION_WIDGET_VIDEO)) {
            Log.i("onReceive", ACTION_WIDGET_VIDEO);
            Intent LaunchIntent = context.getPackageManager().getLaunchIntentForPackage("com.mxtech.videoplayer.ad");
            context.startActivity( LaunchIntent );

        } else if (intent.getAction().equals(ACTION_WIDGET_SEARCH)) {
            Log.i("onReceive", ACTION_WIDGET_SEARCH);
            Intent LaunchIntent = context.getPackageManager().getLaunchIntentForPackage("com.android.chrome");
            context.startActivity( LaunchIntent );

        } else {
            super.onReceive(context, intent);
        }
    }
}