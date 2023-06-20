import { Divider, Flex, Text } from "@chakra-ui/react";
import { SideBar } from "../components/SideBar";
import { Message } from "../components/Message";
import { TrendingMessages } from "../components/TrendingMessages";

export const FeedPage = () => {
  return (
    <Flex w="100%" minH="100vh" bg="blackAlpha.600">
      <SideBar />
      <Flex ml="22%" w="48%" minH="100%" direction="column" align="center">        
      <Text alignSelf="flex-start" m="20px" fontSize="30px" fontWeight="bold">Home</Text>
      <Divider borderColor="black" mb="10px"/>
        <Message/>
        <Message/>
        <Message/>        
        <Message/>        
        <Message/>        
      </Flex>
      <TrendingMessages/>
    </Flex>
  );
};