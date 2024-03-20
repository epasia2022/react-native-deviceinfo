import * as React from 'react';

import { StyleSheet, View, Text } from 'react-native';
import { devicename } from 'react-native-deviceinfo1';

export default function App() {
  const [device, setDevice] = React.useState<number | undefined>();

  React.useEffect(() => {
    devicename().then(setDevice);
  }, []);

  return (
    <View style={styles.container}>
      <Text>Result: {device}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
