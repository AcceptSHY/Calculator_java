package mfp;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculator {
	public static void main(String[] args) {
		final StringBuffer str = new StringBuffer();
		JFrame f = new JFrame("Calculator");
		final JTextField Fieldin = new JTextField();
		Fieldin.setSize(300, 25);
		Fieldin.setLocation(0, 5);
		Fieldin.setHorizontalAlignment(JTextField.RIGHT);
		Fieldin.setEditable(false);
		final JTextField Fieldout = new JTextField();
		Fieldout.setSize(300, 25);
		Fieldout.setLocation(0, 30);
		Fieldout.setHorizontalAlignment(JTextField.RIGHT);
		Fieldout.setEditable(false);
		f.add(Fieldin);
		f.add(Fieldout);
		//设置窗体
		f.setSize(305, 445);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		f.setResizable(false);
		//设置布局
		//给窗体添加组件
		Button[] buttons = new Button[25];
		String[] name = {"2进制","(",")","%","CE","8进制","7","8","9","*","16进制","4","5","6","/","1/x","1","2","3","+","开方",".","0","DE","-"};
		//将组件添加到窗体中
		for(int i=0;i<5;i++)
			for(int j=0;j<5;j++){
				buttons[5*i+j] = new Button(name[5*i+j]);
				buttons[5*i+j].setSize(60, 60);
				buttons[5*i+j].setLocation(j*60,(i+1)*60);
				f.add(buttons[5*i+j]);
		}
		Button ansbtn = new Button("=");
		ansbtn.setSize(300, 60);
		ansbtn.setLocation(0, 60*6);
		f.add(ansbtn);
		
		f.setVisible(true);
		
		//在按钮上添加所需的监听器
		for(int i=0;i<25;i++){
			final String s = name[i];
			if(i==0){
				buttons[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//System.exit(0);
					if(str.length()>0){
						try {
							int ans = Integer.parseInt(str.toString());
							Fieldout.setText(Integer.toBinaryString(ans));
							System.out.println("ans = "+ans);
						} catch (Exception e2) {
							// TODO: handle exception
							Fieldout.setText("不支持此类型数据转换");
						}
						str.delete(0, str.length());
					}
				}
			});
			}
			else if(i==4){
					buttons[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						//System.exit(0);
						str.delete(0, str.length());
						Fieldin.setText("0");
						Fieldout.setText("0");
						System.out.println("str = "+str);
					}
				});
			}
			else if(i==5){
				buttons[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						//System.exit(0);
						if(str.length()>0){
							try {
							int ans = Integer.parseInt(str.toString());
							Fieldout.setText(Integer.toOctalString(ans));
							System.out.println("ans = "+ans);
							} catch (Exception e2) {
								// TODO: handle exception
								Fieldout.setText("不支持此类型数据转换");
							}
							str.delete(0, str.length());
						}
					}
				});
				}
			else if(i==10){
				buttons[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						//System.exit(0);
						if(str.length()>0){
							try {
								int ans = Integer.parseInt(str.toString());
								Fieldout.setText(Integer.toHexString(ans));
								System.out.println("ans = "+ans);
							} catch (Exception e2) {
								// TODO: handle exception
								Fieldout.setText("不支持此类型数据转换");
							}
							str.delete(0, str.length());
						}
					}
				});
				}
			else if(i==15){
				buttons[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						//System.exit(0);
						if(str.length()>0){
							ScriptEngineManager manager = new ScriptEngineManager();
					        ScriptEngine se = manager.getEngineByName("js");
					        Double result = null;
							try {
								result = 1.0d/(Double) se.eval(str.toString());
							} catch (ScriptException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							str.delete(0, str.length());
							try {
								Fieldout.setText(result.toString());
							} catch (Exception e2) {
								// TODO: handle exception
								Fieldout.setText("0");
							}
							
					        System.out.println(result);
						}
					}
				});
			}
			else if(i==20){
				buttons[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						//System.exit(0);
						if(str.length()>0){
							ScriptEngineManager manager = new ScriptEngineManager();
					        ScriptEngine se = manager.getEngineByName("js");
					        Double result = null;
							try {
								result = Math.sqrt((Double) se.eval(str.toString()));
							} catch (ScriptException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							str.delete(0, str.length());
							try {
								Fieldout.setText(result.toString());
							} catch (Exception e2) {
								// TODO: handle exception
								Fieldout.setText("0");
							}
							
					        System.out.println(result);
						}
						
					}
				});
			}
			else if(i==23){
				buttons[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						//System.exit(0);
						int index = str.length()-1;
						if(index>=0){
							str.deleteCharAt(index);
							Fieldin.setText(str.toString());
							System.out.println("str = "+str);
						}
					}
				});
				
			}
			else{
				buttons[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						//System.exit(0);
						str.append(s);
						Fieldin.setText(str.toString());
						System.out.println("str = "+str);
					}
				});
				
			}
		}
		ansbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.exit(0);
				ScriptEngineManager manager = new ScriptEngineManager();
		        ScriptEngine se = manager.getEngineByName("js");
		        Double result = null;
				try {
					result = (Double) se.eval(str.toString());
				} catch (ScriptException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				str.delete(0, str.length());
				try {
					Fieldout.setText(result.toString());
				} catch (Exception e2) {
					// TODO: handle exception
					Fieldout.setText("0");
				}
				
		        System.out.println(result);
			}
		});
		
	}
}
