# coding=gbk
'''>x x��
> y y��
> s   Բ�����
> c   ��ɫ
> marker  Բ����״
> alpha   Բ��͸����                #����ͼҲ������������</pre>'''
import numpy as np
import matplotlib.pyplot as plt

# ɢ��ͼ
N=50
# height=np.random.randint(150,180,20)
# weight=np.random.randint(80,150,20)
x=np.random.randn(N)
y=np.random.randn(N)
plt.scatter(x,y, s=50,c='r',marker='o',alpha=0.5)
plt.show()

# ����ͼ
x=np.linspace(-10,10,100) #��-10��10������ֳ�100��
y=x**2+x**3+x**7
plt.plot(x,y)
plt.show()
'''
# ����ͼ
N=5
y=[20,10,30,25,15]
y1=np.random.randint(10,50,5)
x=np.random.randint(10,1000,N)
index=np.arange(N)
print(index)
plt.bar(index,y,color='red',width=0.3)
plt.bar(left=index+0.3,height=y1,color='black',width=0.3)
plt.show()

# orientation���ú�������ͼ
N=5
y=[20,10,30,25,15]
y1=np.random.randint(10,50,5)
x=np.random.randint(10,1000,N)
index=np.arange(N)
# plt.bar(left=index,height=y,color='red',width=0.3)
# plt.bar(left=index+0.3,height=y1,color='black',width=0.3)
#plt.barh() ����h���Ǻ��������ͼ����������orientation
plt.bar(left=0,bottom=index,width=y,color='red',height=0.5,orientation='horizontal')
plt.show()'''

# .ֱ��ͼ
m1=100
sigma=20
x=m1+sigma*np.random.randn(2000)
plt.hist(x,bins=50,color="green",normed=True)
plt.show()

#˫������ֱ��ͼ
#��ɫԽ��Ƶ��Խ��
#�о�˫���������Ϸֲ�
x=np.random.rand(1000)+2
y=np.random.rand(1000)+3
plt.hist2d(x,y,bins=40)
plt.show()

# ��״ͼ
# ����x,y�����Ϊ1��1���Ӷ��ﵽһ������Բ</pre>
# abels��ǩ����,x�Ƕ�Ӧ�������б�,
# autopct��ʾÿһ������ռ�ı���,
# explodeͻ����ʾĳһ��,
# shadow��Ӱ</pre>
labes=['A','B','C','D']
fracs=[15,30,45,10]
explode=[0,0.1,0.05,0]
#����x,y�����Ϊ1��1���Ӷ��ﵽһ������Բ
plt.axes(aspect=1)
#labels��ǩ����,x�Ƕ�Ӧ�������б�,autopct��ʾÿһ������ռ�ı���,explodeͻ����ʾĳһ��,shadow��Ӱ
plt.pie(x=fracs,labels=labes,autopct="%.0f%%",explode=explode,shadow=True)
plt.show()

# 8.����ͼ 
data=np.random.normal(loc=0,scale=1,size=1000)
#sym �����״��whis���ߵĳ���
plt.boxplot(data,sym="o",whis=1.5)
plt.show()



