package com.demo.androidontheway;

import com.demo.androidontheway.broadcast.BroadcastTestActivity;
import com.demo.androidontheway.bt.BTOpenCameraActivity;
import com.demo.androidontheway.camera.CameraCapture;
import com.demo.androidontheway.camera.VideoRecordingActivity;
import com.demo.androidontheway.customswitch.CustomSwitchActivity;
import com.demo.androidontheway.customviewproperty.MytestViewActivity;
import com.demo.androidontheway.http.HttpClient;
import com.demo.androidontheway.http.WebViewTest;
import com.demo.androidontheway.testinterface.TestInterfaceActivity;
import com.demo.androidontheway.testjni.TestJNIActivity;
import com.demo.androidontheway.testservice.TestServiceActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		build();
	}
	private void build()
	{
		ListView mListView = (ListView)findViewById(R.id.listView);
		//���listItem��������Ӧ�¼�
		mListView.setAdapter(new DemoListAdapter());
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO �Զ���ɵķ������
				onListItemClick(position);
			}
		});
	}
	void onListItemClick(int index) {
		Intent intent = null;
		intent = new Intent(MainActivity.this, demos[index].demoClass);
		this.startActivity(intent);
    }
	private  class DemoListAdapter extends BaseAdapter {
		public DemoListAdapter() {
			super();
		}

		@Override
		public int getCount() {
			return demos.length;
		}
		@Override
		public Object getItem(int index) {
			return  demos[index];
		}

		@Override
		public long getItemId(int id) {
			return id;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO �Զ���ɵķ������
			convertView = View.inflate(MainActivity.this, R.layout.demo_info_item, null);
			TextView title = (TextView)convertView.findViewById(R.id.title);
			TextView desc = (TextView)convertView.findViewById(R.id.desc);
			/*if ( demos[index].demoClass == NaviDemo.class  
			*		|| demos[index].demoClass == CloudSearchDemo.class 
			*		|| demos[index].demoClass == ShareDemo.class
            *       || demos[index].demoClass == PanoramaDemo.class
			*		){
			*	title.setTextColor(Color.YELLOW);
			*	desc.setTextColor(Color.YELLOW);
			*}*/
			title.setText(demos[position].title);
			desc.setText(demos[position].desc);
			return convertView;
		}
	}
	private static final DemoInfo[] demos = {
		new DemoInfo(R.string.demo_title_base,
				R.string.demo_title_base, LaLaPinCheMainActivityDemo.class),
		new DemoInfo(R.string.demo_title_listview_index, R.string.demo_desc_listview_index, IndexActivity.class),
		new DemoInfo(R.string.popupwindow_title, R.string.popupwindow_desc, ActivityPopupWindowTest.class),
		new DemoInfo(R.string.webview_title, R.string.webview_desc, WebViewTest.class),
		new DemoInfo(R.string.httpclient_title, R.string.httpclient_desc, HttpClient.class),
		new DemoInfo(R.string.camera_captrue_title, R.string.camera_captrue_desc, CameraCapture.class),
		new DemoInfo(R.string.bt_test_title, R.string.bt_test_desc, BTOpenCameraActivity.class),
		new DemoInfo(R.string.broadcast_test_title, R.string.broadcast_test_desc, BroadcastTestActivity.class),
		new DemoInfo(R.string.custom_view_property_test_title, R.string.custom_view_property_test_desc, MytestViewActivity.class),
		new DemoInfo(R.string.video_recording_test_title, R.string.video_recording_test_desc, VideoRecordingActivity.class),
		new DemoInfo(R.string.interface_test_title, R.string.interface_test_desc, TestInterfaceActivity.class),
		new DemoInfo(R.string.jni_test_title, R.string.jni_test_desc, TestJNIActivity.class),
		new DemoInfo(R.string.custom_switch_title, R.string.custom_switch_desc, CustomSwitchActivity.class),
		new DemoInfo(R.string.service_test_title, R.string.service_test_desc, TestServiceActivity.class)
		
	};
	private static class DemoInfo{
		private final int title;
		private final int desc;
		private final Class<? extends android.app.Activity> demoClass;

		public DemoInfo(int title , int desc,Class<? extends android.app.Activity> demoClass) {
			this.title = title;
			this.desc  = desc;
			this.demoClass = demoClass;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
