clear,clc
close all

%%%%%%��С���任��%%%%%%%%%%%%%%%%
fs=256;
t=1/fs:1/fs:2;
f1=100;f2=20;f3=30;
s=10*cos(2*pi*f1*t.*(t>=0&t<0.4))+2*cos(2*pi*f2*t.*(t>=0&t<1))+3*sin(2*pi*f3*t.*(t>=0.8&t<=2));
%s=cos(2*pi*f1*t);
subplot(211)
plot(t,s,'b')
title('ԭʼ��Ƶ�ź�')


%%%%%%%%%%%%%%%%%%%%%%% С��ʱƵͼ���� %%%%%%%%%%%%%%%%%%%%%
wavename='cmor4-4'; %%ѡ�ô������������Ƶ�ʾ�Ϊ4 �ĸ�morletС��
totalscal=256;      %�߶����еĳ��ȣ���scal�ĳ���
fc=centfrq(wavename)


%%%%%%%%% ����ʱ����С������ %%%%%
cparam = 2*fc*totalscal;
a = totalscal:-1:1;
scal = cparam./a;
coefs = cwt(s,scal,wavename,1/fs);

f = scal2frq(scal,wavename,1/fs);
subplot(212)
imagesc(t,f,abs(coefs));
colormap(jet)
colorbar
xlabel('ʱ�� t/s')
ylabel('Ƶ�� f/Hz')
title('С��ʱƵͼ')