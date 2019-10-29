# coding=gbk

"""
����x 50ά�����y 1ά������lstm�����ԣ��������� h Ϊ100ά,����¼��ʱ����Ϊ100����λ
���������������һ����������Ԥ��y,�������Ҳֻ����h(0)

������������̡����ĸ�����(x = 1*50dim  y = 1*1dim)Ϊһ�鿴��һ������
��ÿ��ʱ�̵����������ĵ����ۼ�������Ȼ����������ݶ��½������²�����

RNN��Ϊ��Ҫ���ǣ������п�����һ�����������ʱ�̵ĵ����໥��Ӱ�죬���Ҹ��²�����ʱ����һ����������µ�
(��ΪҪ����һ���ĵ����������������ʱ�̵ĵ��������Ը��µ�ʱ��Ͱ��й����ĵ���һ������ˣ�һ�����µ�λ)
x(n)��x(n-1)�йأ�������VARx���������(x,y)
"""


import numpy as np

from lstm import LstmParam, LstmNetwork

class ToyLossLayer:
   
    # Computes square loss with first element of hidden layer array of one lstm node.

    @classmethod
    def loss(self, pred, label):
        return (pred[0] - label) ** 2

    @classmethod
    def bottom_diff(self, pred, label):
        diff = np.zeros_like(pred)
        diff[0] = 2 * (pred[0] - label)
        return diff

def example_0():
    # learns to repeat simple sequence from random inputs
    np.random.seed(0)

    # parameters for input data dimension and lstm cell count 
    mem_cell_ct = 100
    x_dim = 50
    concat_len = x_dim + mem_cell_ct
    lstm_param = LstmParam(mem_cell_ct, x_dim) 
    lstm_net = LstmNetwork(lstm_param)
    
    # predict number
    y_list = [-0.5, 0.2, 0.1, -0.4]
    input_val_arr = [np.random.random(x_dim) for _ in y_list] # һ��list������������ɵ�4�� array(50)
    #  print(input_val_arr)
    
    # �ĸ�����Ϊһ�飬ѭ��100��
    for cur_iter in range(100):
        print ("cur_iter : ", cur_iter)
        
        # �ĸ�����Ϊһ�飬��Ӧyֵ�����в�������
        for ind in range(len(y_list)):
            # ǰ�򴫲�
            lstm_net.x_list_add(input_val_arr[ind])
            print ("y_pred[%d] : %f" % (ind, lstm_net.lstm_node_list[ind].state.h[0]),lstm_net.lstm_node_list[ind].state.h.shape)
            print(lstm_net.lstm_node_list[ind].state.h)

        # ���򴫲�
        loss = lstm_net.y_list_is(y_list, ToyLossLayer)
        # print ("loss: "), loss
        print ("loss: %f" % loss)
        
        # update the parameters
        lstm_param.apply_diff(lr=0.1)
        lstm_net.x_list_clear()


if __name__ == "__main__":
    example_0()
