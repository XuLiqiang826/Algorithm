% �źŹ۲�

data= SignalBuilder('G',5000,5,20);
plot(data,'*')
hold on
plot( 1:length(data),5*ones(1,length(data)),'black' )

%
% �������˲�
% ��֪
% ϵͳ����Ϊ������ϵͳ�ڲ���������Ϊ0

% ����Ϊ0
u = 0*ones(1,length(data));
% ϵͳ������������Ϊ0
N = 0;
% ������������������
W = 20;
% ϵͳ״̬ x ��ʼֵ
x0 = 1;
% ϵͳ�ڲ����Э�����ֵ 200  ��ֵ���ȡ�ô�һ�㣬��Ϊһ��ʼ�����Ҫ���Ź۲⵽��ֵ
P0 = 20;

% �������۲⵽������data
[data_filiter,P] = kalmanFilter( u, data, N, W, x0, P0 );
% ������������������Խ���򿨶����˲���������Ԥ��Ľ�������Թ۲⵽��y��Ԥ���У�����ȱȽ�С��
% �����������ģ�͵�ʱ��۲����������ȻУ��������߱�ø��ӹ⻬�������Ϲ۲�Ľ��������У�����ֵ��ʵ�ʵ�ֵ����һ����ƫ��
% �����������ģ�͵�ʱ��۲������С��У��������߱�ø��Ӷ��ͣ������˴����Ĺ۲�������У�����ֵ��ʵ�ʵ�ֵ����һ����ƫ�

plot(data_filiter,'gp--');
plot(P,'r-');
legend('sensor output','ground value','filiter','P');


%% ����������Ϊ�㣬P�޷�����0

figure(5)
data= SignalBuilder('G',1500,0.3,0.1);
plot(data,'*')
hold on
plot( 1:length(data),0.3*ones(1,length(data)),'black' )

[data_filiter,P] = kalmanFilter( zeros(1,length(data)), data, 0, 0.1, 0.3, 1 );

plot(data_filiter,'gp--');
plot(P,'r-');
legend('sensor output','ground value','filiter','P');

% ΪʲôPkֻ���С�������󣿶���ʦ��ʾ����Ƶ���治ȷ���������

