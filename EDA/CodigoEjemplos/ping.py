"""
A Ping represents a vehicle's position at a given timestamp.
"""

from position import Position


class Ping(object):

    def __init__(self, x, y, timestamp):
        self.position = Position(x, y)
        # Timestamp of the ping, in seconds since the epoch.
        self.timestamp = timestamp

    def get_position(self):
        return self.position

    def get_timestamp(self):
        # timestamp in seconds since a fixed (but arbitrary) epoch.
        return self.timestamp

    def __str__(self):
        return str(self.position) + " @ " + str(self.timestamp)


def seconds_between(ping1, ping2):
    """
    Determines the number of seconds between two given Pings. The result is
    positive if ping1 is earlier than ping2.
    """
    return ping2.get_timestamp() - ping1.get_timestamp()

def sorted_pings(lis):
    if(len(lis) == 0):
        print("its empty") 
    for i in range(1, len(lis)): 
        j = i
        while j > 0 and seconds_between(lis[j], lis[j-1])<0: 
            swap(j, j-1, lis)
            j -= 1 
    return lis

#Helper method that exchanges two data from the list
def swap(i, j, lis):
  lis[i], lis[j] = lis[j], lis[i]
  